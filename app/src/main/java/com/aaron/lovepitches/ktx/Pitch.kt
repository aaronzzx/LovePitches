package com.aaron.lovepitches.ktx

import com.aaron.lovepitches.music.IHeptachord
import com.aaron.lovepitches.music.IKey
import com.aaron.lovepitches.music.IMode
import com.aaron.lovepitches.music.IPentatonic
import com.aaron.lovepitches.music.Pitch

/**
 * @author aaronzzxup@gmail.com
 * @since 2025/6/2
 */

fun Pitch.relativeName(mode: IMode, key: IKey, pitches: List<Pitch> = mode.getPitches(key)): String {
    return "?"
}

fun Pitch.singName(mode: IMode, key: IKey, pitches: List<Pitch> = mode.getPitches(key)): String {
    val index = pitches.indexOf(this)
    if (index < 0) {
        return "?"
    }
    val tonicIndex = pitches.indexOf(key.value)
    if (tonicIndex < 0) {
        return "?"
    }
    val offset = (index % mode.scaleSize) - (tonicIndex % mode.scaleSize)
    if (mode is IPentatonic) {
        return when (offset) {
            0 -> "Do"
            1, -4 -> "Re"
            2, -3 -> "Mi"
            3, -2 -> "Sol"
            4, -1 -> "La"
            else -> "?"
        }
    } else if (mode is IHeptachord) {
        return when (offset) {
            0 -> "Do"
            1, -6 -> "Re"
            2, -5 -> "Mi"
            3, -4 -> "Fa"
            4, -3 -> "Sol"
            5, -2 -> "La"
            6, -1 -> "Ti"
            else -> "?"
        }
    }
    return "?"
}