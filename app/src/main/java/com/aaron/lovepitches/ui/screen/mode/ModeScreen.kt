package com.aaron.lovepitches.ui.screen.mode

import androidx.compose.foundation.gestures.detectTapGestures
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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.input.pointer.pointerInput
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
 * @since 2025/6/3
 */

@Composable
fun ModeScreen() {
    val context = LocalContext.current
    val navController = LocalNavController.current

    Column {
        TopBar(
            onBack = { navController.popBackStack() },
            title = "Mode"
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
                            if (pitch == Pitch.Empty) thisModifier else {
                                thisModifier
                                    .clipToBackground(
                                        color = MaterialTheme.colorScheme.primary,
                                        shape = RectangleShape
                                    )
                                    .pointerInput(context, pitch) {
                                        detectTapGestures(
                                            onPress = {
                                                SoundPlayer.play(context, pitch.rawRes)
                                            }
                                        )
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
        }
    }
}