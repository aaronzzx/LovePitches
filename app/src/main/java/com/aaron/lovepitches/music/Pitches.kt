package com.aaron.lovepitches.music

import com.aaron.lovepitches.R

/**
 * 音高集合
 * 
 * @author aaronzzxup@gmail.com
 * @since 2025/6/2
 */

data object Pitches : IPitches {

    val groups: List<IPitches> = listOf(P0, P1, P2, P3, P4, P5, P6, P7, P8)

    override val pitches: List<Pitch> = P0.pitches + P1.pitches + P2.pitches + P3.pitches +
            P4.pitches + P5.pitches + P6.pitches + P7.pitches + P8.pitches

    /**
     * 大字二组
     */
    data object P0 : IPitches {
        val A0 = Pitch("A", 0, Symbol.None, R.raw.a0)
        val Bb0 = Pitch("B", 0, Symbol.Flat, R.raw.a0_sharp)
        val B0 = Pitch("B", 0, Symbol.None, R.raw.b0)

        override val pitches: List<Pitch> = listOf(A0, Bb0, B0)
    }

    /**
     * 大字一组
     */
    data object P1 : IPitches {
        val C1 = Pitch("C", 1, Symbol.None, R.raw.c1)
        val Db1 = Pitch("D", 1, Symbol.Flat, R.raw.c1_sharp)
        val D1 = Pitch("D", 1, Symbol.None, R.raw.d1)
        val Eb1 = Pitch("E", 1, Symbol.Flat, R.raw.d1_sharp)
        val E1 = Pitch("E", 1, Symbol.None, R.raw.e1)
        val F1 = Pitch("F", 1, Symbol.None, R.raw.f1)
        val Gb1 = Pitch("G", 1, Symbol.Flat, R.raw.f1_sharp)
        val G1 = Pitch("G", 1, Symbol.None, R.raw.g1)
        val Ab1 = Pitch("A", 1, Symbol.Flat, R.raw.g1_sharp)
        val A1 = Pitch("A", 1, Symbol.None, R.raw.a1)
        val Bb1 = Pitch("B", 1, Symbol.Flat, R.raw.a1_sharp)
        val B1 = Pitch("B", 1, Symbol.None, R.raw.b1)

        override val pitches: List<Pitch> = listOf(C1, Db1, D1, Eb1, E1, F1, Gb1, G1, Ab1, A1, Bb1, B1)
    }

    /**
     * 大字组
     */
    data object P2 : IPitches {
        val C2 = Pitch("C", 2, Symbol.None, R.raw.c2)
        val Db2 = Pitch("D", 2, Symbol.Flat, R.raw.c2_sharp)
        val D2 = Pitch("D", 2, Symbol.None, R.raw.d2)
        val Eb2 = Pitch("E", 2, Symbol.Flat, R.raw.d2_sharp)
        val E2 = Pitch("E", 2, Symbol.None, R.raw.e2)
        val F2 = Pitch("F", 2, Symbol.None, R.raw.f2)
        val Gb2 = Pitch("G", 2, Symbol.Flat, R.raw.f2_sharp)
        val G2 = Pitch("G", 2, Symbol.None, R.raw.g2)
        val Ab2 = Pitch("A", 2, Symbol.Flat, R.raw.g2_sharp)
        val A2 = Pitch("A", 2, Symbol.None, R.raw.a2)
        val Bb2 = Pitch("B", 2, Symbol.Flat, R.raw.a2_sharp)
        val B2 = Pitch("B", 2, Symbol.None, R.raw.b2)

        override val pitches: List<Pitch> = listOf(C2, Db2, D2, Eb2, E2, F2, Gb2, G2, Ab2, A2, Bb2, B2)
    }

    /**
     * 小字组
     */
    data object P3 : IPitches {
        val C3 = Pitch("C", 3, Symbol.None, R.raw.c3)
        val Db3 = Pitch("D", 3, Symbol.Flat, R.raw.c3_sharp)
        val D3 = Pitch("D", 3, Symbol.None, R.raw.d3)
        val Eb3 = Pitch("E", 3, Symbol.Flat, R.raw.d3_sharp)
        val E3 = Pitch("E", 3, Symbol.None, R.raw.e3)
        val F3 = Pitch("F", 3, Symbol.None, R.raw.f3)
        val Gb3 = Pitch("G", 3, Symbol.Flat, R.raw.f3_sharp)
        val G3 = Pitch("G", 3, Symbol.None, R.raw.g3)
        val Ab3 = Pitch("A", 3, Symbol.Flat, R.raw.g3_sharp)
        val A3 = Pitch("A", 3, Symbol.None, R.raw.a3)
        val Bb3 = Pitch("B", 3, Symbol.Flat, R.raw.a3_sharp)
        val B3 = Pitch("B", 3, Symbol.None, R.raw.b3)

        override val pitches: List<Pitch> = listOf(C3, Db3, D3, Eb3, E3, F3, Gb3, G3, Ab3, A3, Bb3, B3)
    }

    /**
     * 小字一组
     */
    data object P4 : IPitches {
        val C4 = Pitch("C", 4, Symbol.None, R.raw.c4)
        val Db4 = Pitch("D", 4, Symbol.Flat, R.raw.c4_sharp)
        val D4 = Pitch("D", 4, Symbol.None, R.raw.d4)
        val Eb4 = Pitch("E", 4, Symbol.Flat, R.raw.d4_sharp)
        val E4 = Pitch("E", 4, Symbol.None, R.raw.e4)
        val F4 = Pitch("F", 4, Symbol.None, R.raw.f4)
        val Gb4 = Pitch("G", 4, Symbol.Flat, R.raw.f4_sharp)
        val G4 = Pitch("G", 4, Symbol.None, R.raw.g4)
        val Ab4 = Pitch("A", 4, Symbol.Flat, R.raw.g4_sharp)
        val A4 = Pitch("A", 4, Symbol.None, R.raw.a4)
        val Bb4 = Pitch("B", 4, Symbol.Flat, R.raw.a4_sharp)
        val B4 = Pitch("B", 4, Symbol.None, R.raw.b4)

        override val pitches: List<Pitch> = listOf(C4, Db4, D4, Eb4, E4, F4, Gb4, G4, Ab4, A4, Bb4, B4)
    }

    /**
     * 小字二组
     */
    data object P5 : IPitches {
        val C5 = Pitch("C", 5, Symbol.None, R.raw.c5)
        val Db5 = Pitch("D", 5, Symbol.Flat, R.raw.c5_sharp)
        val D5 = Pitch("D", 5, Symbol.None, R.raw.d5)
        val Eb5 = Pitch("E", 5, Symbol.Flat, R.raw.d5_sharp)
        val E5 = Pitch("E", 5, Symbol.None, R.raw.e5)
        val F5 = Pitch("F", 5, Symbol.None, R.raw.f5)
        val Gb5 = Pitch("G", 5, Symbol.Flat, R.raw.f5_sharp)
        val G5 = Pitch("G", 5, Symbol.None, R.raw.g5)
        val Ab5 = Pitch("A", 5, Symbol.Flat, R.raw.g5_sharp)
        val A5 = Pitch("A", 5, Symbol.None, R.raw.a5)
        val Bb5 = Pitch("B", 5, Symbol.Flat, R.raw.a5_sharp)
        val B5 = Pitch("B", 5, Symbol.None, R.raw.b5)

        override val pitches: List<Pitch> = listOf(C5, Db5, D5, Eb5, E5, F5, Gb5, G5, Ab5, A5, Bb5, B5)
    }

    /**
     * 小字三组
     */
    data object P6 : IPitches {
        val C6 = Pitch("C", 6, Symbol.None, R.raw.c6)
        val Db6 = Pitch("D", 6, Symbol.Flat, R.raw.c6_sharp)
        val D6 = Pitch("D", 6, Symbol.None, R.raw.d6)
        val Eb6 = Pitch("E", 6, Symbol.Flat, R.raw.d6_sharp)
        val E6 = Pitch("E", 6, Symbol.None, R.raw.e6)
        val F6 = Pitch("F", 6, Symbol.None, R.raw.f6)
        val Gb6 = Pitch("G", 6, Symbol.Flat, R.raw.f6_sharp)
        val G6 = Pitch("G", 6, Symbol.None, R.raw.g6)
        val Ab6 = Pitch("A", 6, Symbol.Flat, R.raw.g6_sharp)
        val A6 = Pitch("A", 6, Symbol.None, R.raw.a6)
        val Bb6 = Pitch("B", 6, Symbol.Flat, R.raw.a6_sharp)
        val B6 = Pitch("B", 6, Symbol.None, R.raw.b6)

        override val pitches: List<Pitch> = listOf(C6, Db6, D6, Eb6, E6, F6, Gb6, G6, Ab6, A6, Bb6, B6)
    }

    /**
     * 小字四组
     */
    data object P7 : IPitches {
        val C7 = Pitch("C", 7, Symbol.None, R.raw.c7)
        val Db7 = Pitch("D", 7, Symbol.Flat, R.raw.c7_sharp)
        val D7 = Pitch("D", 7, Symbol.None, R.raw.d7)
        val Eb7 = Pitch("E", 7, Symbol.Flat, R.raw.d7_sharp)
        val E7 = Pitch("E", 7, Symbol.None, R.raw.e7)
        val F7 = Pitch("F", 7, Symbol.None, R.raw.f7)
        val Gb7 = Pitch("G", 7, Symbol.Flat, R.raw.f7_sharp)
        val G7 = Pitch("G", 7, Symbol.None, R.raw.g7)
        val Ab7 = Pitch("A", 7, Symbol.Flat, R.raw.g7_sharp)
        val A7 = Pitch("A", 7, Symbol.None, R.raw.a7)
        val Bb7 = Pitch("B", 7, Symbol.Flat, R.raw.a7_sharp)
        val B7 = Pitch("B", 7, Symbol.None, R.raw.b7)

        override val pitches: List<Pitch> = listOf(C7, Db7, D7, Eb7, E7, F7, Gb7, G7, Ab7, A7, Bb7, B7)
    }

    /**
     * 小字五组
     */
    data object P8 : IPitches {
        val C8 = Pitch("C", 8, Symbol.None, R.raw.c8)

        override val pitches: List<Pitch> = listOf(C8)
    }
}

data class Pitch(
    val name: String,
    val group: Int,
    val symbol: Symbol,
    val audioFile: Int
) {

    companion object {
        val Empty = Pitch("", -1, Symbol.None, 0)
    }
    
    val qualifiedName: String = run {
        val symbolText = when (symbol) {
            Symbol.None -> ""
            Symbol.Sharp -> "♯"
            Symbol.Flat -> "♭"
        }
        "${name}${symbolText}$group"
    }

    override fun toString(): String {
        return qualifiedName
    }
}

enum class Symbol {

    None, Sharp, Flat
}

interface IPitches {

    val pitches: List<Pitch>
}