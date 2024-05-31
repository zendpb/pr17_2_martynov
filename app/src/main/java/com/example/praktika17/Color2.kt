package com.example.praktika17

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import androidx.preference.PreferenceManager
import android.graphics.Color.RED
import android.graphics.Color.BLUE
import android.graphics.Color.GREEN

class Color2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_color)

        val prefs = PreferenceManager.getDefaultSharedPreferences(this)
        val launchCount = prefs.getInt("launchCount", 0)

        val rootView = findViewById<View>(android.R.id.content).rootView

        when {
            launchCount == 0 -> rootView.setBackgroundColor(RED)
            launchCount % 2 == 0 -> rootView.setBackgroundColor(GREEN)
            else -> rootView.setBackgroundColor(BLUE)
        }

        prefs.edit {
            putInt("launchCount", launchCount + 1)
        }
    }
}

