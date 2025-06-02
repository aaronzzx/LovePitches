package com.aaron.lovepitches.music

/**
 * 调式
 *
 * @author aaronzzxup@gmail.com
 * @since 2025/6/2
 */

data object Modes {

    val value: List<IMode> = ChineseMode.value + ChurchMode.value

    /**
     * 宫商角徵羽，即宫等于1(Do)，商等于2(Re)，角等于3(Mi)，徵等于5(Sol)，羽等于6(La)，亦称作五音
     */
    data object ChineseMode {

        val value: List<IPentatonic> = listOf(Gong, Shang, Jue, Zhi, Yu)

        /**
         * 宫调式
         */
        data object Gong : IPentatonic {

            override val name: String = "宫"

            override val Do: Pitch = Pitches.P3.C3
            override val Re: Pitch = Pitches.P3.D3
            override val Mi: Pitch = Pitches.P3.E3
            override val Sol: Pitch = Pitches.P3.G3
            override val La: Pitch = Pitches.P3.A3

            override val DoIndex: Int = 0
            override val ReIndex: Int = 2
            override val MiIndex: Int = 4
            override val SolIndex: Int = 7
            override val LaIndex: Int = 9
        }

        /**
         * 商调式
         */
        data object Shang : IPentatonic {

            override val name: String = "商"

            override val Do: Pitch = Pitches.P3.D3
            override val Re: Pitch = Pitches.P3.E3
            override val Mi: Pitch = Pitches.P3.G3
            override val Sol: Pitch = Pitches.P3.A3
            override val La: Pitch = Pitches.P4.C4

            override val DoIndex: Int = 0
            override val ReIndex: Int = 2
            override val MiIndex: Int = 5
            override val SolIndex: Int = 7
            override val LaIndex: Int = 10
        }

        /**
         * 角调式
         */
        data object Jue : IPentatonic {

            override val name: String = "角"

            override val Do: Pitch = Pitches.P3.E3
            override val Re: Pitch = Pitches.P3.G3
            override val Mi: Pitch = Pitches.P3.A3
            override val Sol: Pitch = Pitches.P4.C4
            override val La: Pitch = Pitches.P4.D4

            override val DoIndex: Int = 0
            override val ReIndex: Int = 3
            override val MiIndex: Int = 5
            override val SolIndex: Int = 8
            override val LaIndex: Int = 10
        }

        /**
         * 徵调式
         */
        data object Zhi : IPentatonic {

            override val name: String = "徵"

            override val Do: Pitch = Pitches.P3.G3
            override val Re: Pitch = Pitches.P3.A3
            override val Mi: Pitch = Pitches.P4.C4
            override val Sol: Pitch = Pitches.P4.D4
            override val La: Pitch = Pitches.P4.E4

            override val DoIndex: Int = 0
            override val ReIndex: Int = 2
            override val MiIndex: Int = 5
            override val SolIndex: Int = 7
            override val LaIndex: Int = 9
        }

        /**
         * 羽调式
         */
        data object Yu : IPentatonic {

            override val name: String = "羽"

            override val Do: Pitch = Pitches.P3.A3
            override val Re: Pitch = Pitches.P4.C4
            override val Mi: Pitch = Pitches.P4.D4
            override val Sol: Pitch = Pitches.P4.E4
            override val La: Pitch = Pitches.P4.G4

            override val DoIndex: Int = 0
            override val ReIndex: Int = 3
            override val MiIndex: Int = 5
            override val SolIndex: Int = 7
            override val LaIndex: Int = 10
        }
    }

    data object ChurchMode {

        val value: List<IHeptachord> = listOf(Ionian, Dorian, Phrygian, Lydian, Mixolydian, Aeolian, Locrian)

        /**
         * 伊奥尼亚（Ionian）调式：以首调唱名法的Do为主音的调式，音阶关系是全、全、半、全、全、全、半，与中国七声清乐宫调式及自然大调的音阶结构完全相同，属于大调类调式。
         */
        data object Ionian : IHeptachord {

            override val name: String = "Ionian"

            override val Do: Pitch = Pitches.P3.C3
            override val Re: Pitch = Pitches.P3.D3
            override val Mi: Pitch = Pitches.P3.E3
            override val Fa: Pitch = Pitches.P3.F3
            override val Sol: Pitch = Pitches.P3.G3
            override val La: Pitch = Pitches.P3.A3
            override val Ti: Pitch = Pitches.P3.B3

            override val DoIndex: Int = 0
            override val ReIndex: Int = 2
            override val MiIndex: Int = 4
            override val FaIndex: Int = 5
            override val SolIndex: Int = 7
            override val LaIndex: Int = 9
            override val TiIndex: Int = 11
        }

        /**
         * 多利亚（Dorian）调式：以首调唱名法的Re为主音的调式，音阶关系是全、半、全、全、全、半、全，与自然小调相比，主音下方有一个小三度（多利亚三度），与中国七声清乐商调式的音阶结构完全相同，属于小调类调式。
         */
        data object Dorian : IHeptachord {

            override val name: String = "Dorian"

            override val Do: Pitch = Pitches.P3.D3
            override val Re: Pitch = Pitches.P3.E3
            override val Mi: Pitch = Pitches.P3.F3
            override val Fa: Pitch = Pitches.P3.G3
            override val Sol: Pitch = Pitches.P3.A3
            override val La: Pitch = Pitches.P3.B3
            override val Ti: Pitch = Pitches.P4.C4

            override val DoIndex: Int = 0
            override val ReIndex: Int = 2
            override val MiIndex: Int = 3
            override val FaIndex: Int = 5
            override val SolIndex: Int = 7
            override val LaIndex: Int = 9
            override val TiIndex: Int = 10
        }

        /**
         * 弗里吉亚（Phrygian）调式：以首调唱名法的Mi为主音的调式，音阶关系是半、全、全、全、半、全、全，与自然小调相比，主音上方有一个小二度（弗里吉亚二度），与中国七声清乐角调式的音阶结构完全相同，属于小调类调式。
         */
        data object Phrygian : IHeptachord {

            override val name: String = "Phrygian"

            override val Do: Pitch = Pitches.P3.E3
            override val Re: Pitch = Pitches.P3.F3
            override val Mi: Pitch = Pitches.P3.G3
            override val Fa: Pitch = Pitches.P3.A3
            override val Sol: Pitch = Pitches.P3.B3
            override val La: Pitch = Pitches.P4.C4
            override val Ti: Pitch = Pitches.P4.D4

            override val DoIndex: Int = 0
            override val ReIndex: Int = 1
            override val MiIndex: Int = 3
            override val FaIndex: Int = 5
            override val SolIndex: Int = 7
            override val LaIndex: Int = 8
            override val TiIndex: Int = 10
        }

        /**
         * 利地亚（Lydian）调式：以首调唱名法的Fa为主音的调式，音阶关系是全、全、全、半、全、全、半，与自然大调相比，主音上方有一个三全音的音程——增四度（利地亚四度），属于大调类调式。
         */
        data object Lydian : IHeptachord {

            override val name: String = "Lydian"

            override val Do: Pitch = Pitches.P3.F3
            override val Re: Pitch = Pitches.P3.G3
            override val Mi: Pitch = Pitches.P3.A3
            override val Fa: Pitch = Pitches.P3.B3
            override val Sol: Pitch = Pitches.P4.C4
            override val La: Pitch = Pitches.P4.D4
            override val Ti: Pitch = Pitches.P4.E4

            override val DoIndex: Int = 0
            override val ReIndex: Int = 2
            override val MiIndex: Int = 4
            override val FaIndex: Int = 6
            override val SolIndex: Int = 7
            override val LaIndex: Int = 9
            override val TiIndex: Int = 11
        }

        /**
         * 混合利地亚（Mixolydian）调式：以首调唱名法的Sol为主音的调式，音阶关系是全、全、半、全、全、半、全，与自然大调相比，主音上方有一个小七度（混合利地亚七度），与中国七声清乐徴调式的音阶结构完全相同，属于大调类调式。
         */
        data object Mixolydian : IHeptachord {

            override val name: String = "Mixolydian"

            override val Do: Pitch = Pitches.P3.G3
            override val Re: Pitch = Pitches.P3.A3
            override val Mi: Pitch = Pitches.P3.B3
            override val Fa: Pitch = Pitches.P4.C4
            override val Sol: Pitch = Pitches.P4.D4
            override val La: Pitch = Pitches.P4.E4
            override val Ti: Pitch = Pitches.P4.F4

            override val DoIndex: Int = 0
            override val ReIndex: Int = 2
            override val MiIndex: Int = 4
            override val FaIndex: Int = 5
            override val SolIndex: Int = 7
            override val LaIndex: Int = 9
            override val TiIndex: Int = 10
        }

        /**
         * 爱奥利亚（Aeolian）调式：以首调唱名法的La为主音的调式，音阶关系是全、半、全、全、半、全、全，与中国七声清乐羽调式及自然小调的音阶结构完全相同，属于小调类调式。
         */
        data object Aeolian : IHeptachord {

            override val name: String = "Aeolian"

            override val Do: Pitch = Pitches.P3.A3
            override val Re: Pitch = Pitches.P3.B3
            override val Mi: Pitch = Pitches.P4.C4
            override val Fa: Pitch = Pitches.P4.D4
            override val Sol: Pitch = Pitches.P4.E4
            override val La: Pitch = Pitches.P4.F4
            override val Ti: Pitch = Pitches.P4.G4

            override val DoIndex: Int = 0
            override val ReIndex: Int = 2
            override val MiIndex: Int = 3
            override val FaIndex: Int = 5
            override val SolIndex: Int = 7
            override val LaIndex: Int = 8
            override val TiIndex: Int = 10
        }

        /**
         * 洛克利亚（Locrian）调式：以首调唱名法的Ti为主音的调式，音阶关系是半、全、全、半、全、全、全，与弗里吉亚调式相比，主音上方有一个三全音的音程——减五度（洛克里亚五度），是最具小调特点的调式。
         */
        data object Locrian : IHeptachord {

            override val name: String = "Locrian"

            override val Do: Pitch = Pitches.P3.B3
            override val Re: Pitch = Pitches.P4.C4
            override val Mi: Pitch = Pitches.P4.D4
            override val Fa: Pitch = Pitches.P4.E4
            override val Sol: Pitch = Pitches.P4.F4
            override val La: Pitch = Pitches.P4.G4
            override val Ti: Pitch = Pitches.P4.A4

            override val DoIndex: Int = 0
            override val ReIndex: Int = 1
            override val MiIndex: Int = 3
            override val FaIndex: Int = 5
            override val SolIndex: Int = 6
            override val LaIndex: Int = 8
            override val TiIndex: Int = 10
        }
    }
}

/**
 * 七声音阶（英Heptachord），是在八度音程之内，由七个相邻的音所组成的音阶。中国战国时期已有七声音阶的出现，由原有的五声音阶宫、商、角、徵、羽(CDEGA)五音加上变徵与变宫两音而成(CDE#FGAB)。西洋七声音阶的出现可分为教会音阶及近代大小调音阶两种
 */
interface IHeptachord : IMode {

    val Do: Pitch
    val Re: Pitch
    val Mi: Pitch
    val Fa: Pitch
    val Sol: Pitch
    val La: Pitch
    val Ti: Pitch

    val DoIndex: Int
    val ReIndex: Int
    val MiIndex: Int
    val FaIndex: Int
    val SolIndex: Int
    val LaIndex: Int
    val TiIndex: Int
}

/**
 * 五声音阶，汉族古代音律 [1-2]。就是按五度的相生顺序，从宫音开始到羽音，依次为：宫—商—角—徵—羽；如按音高顺序排列，即为：1 2 3 5 6 宫 商 角 徵（zhǐ） 羽。唐代时使用“合、四、乙、尺、工”。
 */
interface IPentatonic : IMode {

    val Do: Pitch
    val Re: Pitch
    val Mi: Pitch
    val Sol: Pitch
    val La: Pitch

    val DoIndex: Int
    val ReIndex: Int
    val MiIndex: Int
    val SolIndex: Int
    val LaIndex: Int
}

interface IMode {

    val name: String
}