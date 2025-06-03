package com.aaron.lovepitches

import android.content.Context
import android.media.SoundPool
import androidx.annotation.RawRes
import androidx.compose.ui.util.fastForEach
import kotlinx.coroutines.Job
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

/**
 * @author aaronzzxup@gmail.com
 * @since 2025/6/3
 */
object SoundPlayer {

    private val soundPool: SoundPool = run {
        SoundPool
            .Builder()
            .setMaxStreams(88)
            .build()
    }

    private val soundIds = mutableMapOf<Int, Int>()
    private val coroutineScope = MainScope()
    private var loopJob: Job? = null

    fun cancelLoop() {
        loopJob?.cancel()
        loopJob = null
    }

    fun play(
        context: Context,
        raw: List<Int>,
        bmp: Int = 90,
        rate: Float = 1f,
        loop: Boolean = true
    ) {
        if (raw.isEmpty()) {
            return
        }
        loopJob?.cancel()
        loopJob = null
        coroutineScope.launch {
            val delayMs = ((60f / bmp) * 1000).toLong()
            do {
                raw.fastForEach { res ->
                    if (res > 0) {
                        play(context, res, rate)
                    }
                    delay(delayMs)
                }
            } while (isActive && loop)
        }.also { job ->
            if (loop) {
                loopJob = job
            }
        }
    }

    fun play(context: Context, @RawRes raw: Int, rate: Float = 1f) {
        val soundPool = soundPool
        val soundIds = soundIds
        val cache = soundIds[raw]
        if (cache != null) {
            soundPool.play(cache, 1f, 1f, 1, 0, rate)
            return
        }

        soundPool.load(context, raw, 1)
        soundPool.setOnLoadCompleteListener { pool, sampleId, status ->
            if (status == 0) {
                soundPool.play(sampleId, 1f, 1f, 1, 0, rate)
                soundIds[raw] = sampleId
            }
        }
    }

    fun pauseAll() {
        cancelLoop()
        soundPool.autoPause()
    }

    fun clear() {
        val soundIds = soundIds
        soundIds.forEach { (_, soundId) ->
            soundPool.unload(soundId)
        }
        soundIds.clear()
    }

    fun release() {
        coroutineScope.cancel()
        clear()
        soundPool.release()
    }
}