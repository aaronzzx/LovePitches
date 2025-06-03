package com.aaron.lovepitches

import android.content.res.Configuration
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.aaron.lovepitches.ui.LovePitchesApp

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        myEnableEdgeToEdge()
        super.onCreate(savedInstanceState)

        setContent {
            LovePitchesApp()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        SoundPlayer.pauseAll()
    }
}

private fun ComponentActivity.myEnableEdgeToEdge(isAppNightMode: Boolean = false) {
    enableEdgeToEdge(
        statusBarStyle = SystemBarStyle.auto(Color.TRANSPARENT, Color.TRANSPARENT) { resources ->
            val flag = resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
            flag == Configuration.UI_MODE_NIGHT_YES || isAppNightMode
        },
        navigationBarStyle = SystemBarStyle.auto(DefaultLightScrim, DefaultDarkScrim) { resources ->
            val flag = resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
            flag == Configuration.UI_MODE_NIGHT_YES || isAppNightMode
        }
    )
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
        window.isNavigationBarContrastEnforced = false
    }
}

private val DefaultLightScrim = Color.argb(0xe6, 0xFF, 0xFF, 0xFF)
private val DefaultDarkScrim = Color.argb(0x80, 0x1b, 0x1b, 0x1b)