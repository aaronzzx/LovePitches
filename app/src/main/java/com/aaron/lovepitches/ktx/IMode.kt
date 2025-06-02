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

val IMode.scales: List<Pitch> get() = when (this) {
    is IPentatonic -> this.scales
    is IHeptachord -> this.scales
    else -> error("Unknown mode: $this")
}

val IMode.scaleSize: Int get() = when (this) {
    is IPentatonic -> this.scaleSize
    is IHeptachord -> this.scaleSize
    else -> error("Unknown mode: $this")
}

fun IMode.getPitches(key: IKey): List<Pitch> {
    if (this is IPentatonic) {
        return this.getPitches(key)
    } else if (this is IHeptachord) {
        return this.getPitches(key)
    }
    error("Unknown mode: $this")
}