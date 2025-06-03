package com.aaron.lovepitches.entity

import androidx.annotation.Keep
import kotlinx.serialization.Serializable

/**
 * @author aaronzzxup@gmail.com
 * @since 2025/6/2
 */
data object Routes {

    @Keep
    @Serializable
    data object Home

    @Keep
    @Serializable
    data object Intervals

    @Keep
    @Serializable
    data object Pitches

    @Keep
    @Serializable
    data object Mode
}