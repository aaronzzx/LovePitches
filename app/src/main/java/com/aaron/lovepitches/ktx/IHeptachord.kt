package com.aaron.lovepitches.ktx

import com.aaron.lovepitches.music.IHeptachord
import com.aaron.lovepitches.music.IKey
import com.aaron.lovepitches.music.Pitch
import com.aaron.lovepitches.music.Pitches

/**
 * @author aaronzzxup@gmail.com
 * @since 2025/6/2
 */

val IHeptachord.scales: List<Pitch> get() = listOf(Do, Re, Mi, Fa, Sol, La, Ti)

val IHeptachord.scaleSize: Int get() = scales.size

fun IHeptachord.getPitches(key: IKey, includeSpace: Boolean = true): List<Pitch> {
    val allPitches = Pitches.pitches
    val tonic = key.value
    val tonicIndex = allPitches.indexOf(tonic)
    if (tonicIndex < 0) {
        return emptyList()
    }
    var tonicIndexTemp = tonicIndex
    while (tonicIndexTemp > 0) {
        tonicIndexTemp -= 12
    }
    val pitches = mutableListOf<Pitch>()
    var init = true
    while (tonicIndexTemp <= allPitches.lastIndex) {
        pitches.tryAdd(allPitches, tonicIndexTemp, DoIndex, includeSpace)
        pitches.tryAdd(allPitches, tonicIndexTemp, ReIndex, includeSpace)
        pitches.tryAdd(allPitches, tonicIndexTemp, MiIndex, includeSpace)
        pitches.tryAdd(allPitches, tonicIndexTemp, FaIndex, includeSpace)
        pitches.tryAdd(allPitches, tonicIndexTemp, SolIndex, includeSpace)
        pitches.tryAdd(allPitches, tonicIndexTemp, LaIndex, includeSpace)
        pitches.tryAdd(allPitches, tonicIndexTemp, TiIndex, includeSpace)
        if (init && pitches.last() == Pitch.Empty) {
            pitches.clear()
        }
        init = false
        tonicIndexTemp += 12
    }
    return pitches
}