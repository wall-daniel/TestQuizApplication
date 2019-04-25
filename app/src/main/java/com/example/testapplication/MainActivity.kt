package com.example.testapplication

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v4.app.FragmentActivity
import android.widget.Button

class MainActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // When clicked this button starts the quiz game
        var button: Button = findViewById(R.id.start_game_button)
        button.setOnClickListener {
            startActivity(Intent(this, QuizActivity::class.java))
        }
    }
}
