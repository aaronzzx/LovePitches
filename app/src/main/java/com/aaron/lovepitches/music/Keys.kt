package com.aaron.lovepitches.music

/**
 * 调式主音
 *
 * @author aaronzzxup@gmail.com
 * @since 2025/6/2
 */

data object Keys {

    val value: List<IKey> = listOf(CKey, DbKey, DKey, EbKey, EKey, FKey, GbKey, GKey, AbKey, AKey, BbKey, BKey)

    data object CKey : IKey {

        override val name: String = "C"

        override val value: Pitch = Pitches.P3.C3
    }

    data object DbKey : IKey {

        override val name: String = "D♭"

        override val value: Pitch = Pitches.P3.Db3
    }

    data object DKey : IKey {

        override val name: String = "D"

        override val value: Pitch = Pitches.P3.D3
    }

    data object EbKey : IKey {

        override val name: String = "E♭"

        override val value: Pitch = Pitches.P3.Eb3
    }

    data object EKey : IKey {

        override val name: String = "E"

        override val value: Pitch = Pitches.P3.E3
    }

    data object FKey : IKey {

        override val name: String = "F"

        override val value: Pitch = Pitches.P3.F3
    }

    data object GbKey : IKey {

        override val name: String = "G♭"

        override val value: Pitch = Pitches.P3.Gb3
    }

    data object GKey : IKey {

        override val name: String = "G"

        override val value: Pitch = Pitches.P3.G3
    }

    data object AbKey : IKey {

        override val name: String = "A♭"

        override val value: Pitch = Pitches.P3.Ab3
    }

    data object AKey : IKey {

        override val name: String = "A"

        override val value: Pitch = Pitches.P3.A3
    }

    data object BbKey : IKey {

        override val name: String = "B♭"

        override val value: Pitch = Pitches.P3.Bb3
    }

    data object BKey : IKey {

        override val name: String = "B"

        override val value: Pitch = Pitches.P3.B3
    }
}

interface IKey {

    val name: String

    val value: Pitch
}