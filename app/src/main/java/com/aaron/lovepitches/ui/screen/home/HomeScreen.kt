package com.aaron.lovepitches.ui.screen.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aaron.compose.ktx.clipToBackground
import com.aaron.compose.ktx.onSingleClick
import com.aaron.lovepitches.R
import com.aaron.lovepitches.ui.widgets.TopBar

/**
 * @author aaronzzxup@gmail.com
 * @since 2025/6/2
 */

@Composable
fun HomeScreen(
    onNavToIntervals: () -> Unit,
    onNavToPitches: () -> Unit,
    onNavToMode: () -> Unit
) {
    Column {
        TopBar(
            onBack = { /*TODO*/ },
            title = stringResource(R.string.app_name),
            titleStyle = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.W900),
            showBackIcon = false
        )

        LazyVerticalGrid(
            modifier = Modifier.fillMaxSize(),
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1f)
                        .clipToBackground(
                            color = MaterialTheme.colorScheme.primary,
                            shape = CircleShape
                        )
                        .onSingleClick {
                            onNavToMode()
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Mode",
                        fontSize = 20.sp,
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                }
            }
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1f)
                        .clipToBackground(
                            color = MaterialTheme.colorScheme.tertiary,
                            shape = CircleShape
                        )
                        .onSingleClick {
                            onNavToIntervals()
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Intervals",
                        fontSize = 20.sp,
                        color = MaterialTheme.colorScheme.onTertiary
                    )
                }
            }
        }
    }
}