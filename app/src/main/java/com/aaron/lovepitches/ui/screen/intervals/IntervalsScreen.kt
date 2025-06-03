package com.aaron.lovepitches.ui.screen.intervals

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aaron.compose.ktx.clipToBackground
import com.aaron.compose.ktx.onClick
import com.aaron.lovepitches.SoundPlayer
import com.aaron.lovepitches.ktx.LocalNavController
import com.aaron.lovepitches.ktx.getPitches
import com.aaron.lovepitches.ktx.scaleSize
import com.aaron.lovepitches.ktx.singName
import com.aaron.lovepitches.music.IKey
import com.aaron.lovepitches.music.IMode
import com.aaron.lovepitches.music.Keys
import com.aaron.lovepitches.music.Modes
import com.aaron.lovepitches.music.Pitch
import com.aaron.lovepitches.ui.widgets.TopBar

/**
 * @author aaronzzxup@gmail.com
 * @since 2025/6/2
 */

@Composable
fun IntervalsScreen() {
    val context = LocalContext.current
    val navController = LocalNavController.current

    DisposableEffect(Unit) {
        onDispose {
            SoundPlayer.pauseAll()
        }
    }

    Column {
        val list = remember { mutableStateListOf<Pitch>() }
        TopBar(
            onBack = { navController.popBackStack() },
            title = "Intervals",
            actions = {
                Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    Button(
                        onClick = {
                            if (list.isNotEmpty()) {
                                SoundPlayer.play(
                                    context = context,
                                    raw = list.map { it.rawRes },
                                    bmp = 120,
                                    rate = 1f
                                )
                            }
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.PlayArrow,
                            contentDescription = null
                        )
                    }
                    Button(
                        onClick = {
                            list.clear()
                            SoundPlayer.pauseAll()
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Pause,
                            contentDescription = null
                        )
                    }
                }
            }
        )

        var mode: IMode by remember {
            mutableStateOf(Modes.ChurchMode.Ionian)
        }
        var key: IKey by remember {
            mutableStateOf(Keys.CKey)
        }
        val pitches: List<Pitch> = remember(mode, key) {
            mode.getPitches(key)
        }

        LazyVerticalGrid(
            modifier = Modifier.fillMaxSize(),
            columns = GridCells.Fixed(mode.scaleSize),
            verticalArrangement = Arrangement.spacedBy(2.dp),
            horizontalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            item(
                span = { GridItemSpan(mode.scaleSize) },
                contentType = "Selector"
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight()
                            .onClick {
                                list.clear()
                                SoundPlayer.pauseAll()
                                val modes = Modes.value
                                if (mode == modes.last()) {
                                    mode = modes.first()
                                } else {
                                    val index = modes.indexOf(mode)
                                    mode = modes[index + 1]
                                }
                            }
                            .wrapContentSize(),
                        text = "Mode: ${mode.name}"
                    )
                    Text(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight()
                            .onClick {
                                list.clear()
                                SoundPlayer.pauseAll()
                                val keys = Keys.value
                                if (key == keys.last()) {
                                    key = keys.first()
                                } else {
                                    val index = keys.indexOf(key)
                                    key = keys[index + 1]
                                }
                            }
                            .wrapContentSize(),
                        text = "Key: ${key.name}"
                    )
                }
            }
            itemsIndexed(
                items = pitches,
                key = { index, pitch ->
                    if (pitch == Pitch.Empty) index else pitch.qualifiedName
                },
                contentType = { _, _ -> "Scale" }
            ) { _, pitch ->
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1f)
                        .let { thisModifier ->
                            if (pitch == Pitch.Empty) {
                                thisModifier.onClick {
                                    list.add(pitch)
                                }
                            } else {
                                thisModifier
                                    .clipToBackground(
                                        color = MaterialTheme.colorScheme.primary,
                                        shape = RectangleShape
                                    )
                                    .onClick {
                                        list.add(pitch)
                                    }
                            }
                        },
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    if (pitch != Pitch.Empty) {
                        Text(
                            text = pitch.singName(mode, key, pitches),
                            color = MaterialTheme.colorScheme.onPrimary,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "(${pitch.qualifiedName})",
                            color = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.75f),
                            fontSize = 10.sp
                        )
                    }
                }
            }

            item(
                span = { GridItemSpan(mode.scaleSize) },
                contentType = "Intervals"
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = remember(mode, key, pitches) {
                        derivedStateOf {
                            list
                                .toList()
                                .joinToString {
                                    if (it == Pitch.Empty) {
                                        "Empty"
                                    } else {
                                        "${it.singName(mode, key, pitches)}(${it.qualifiedName})"
                                    }
                                }
                        }
                    }.value
                )
            }
        }
    }
}