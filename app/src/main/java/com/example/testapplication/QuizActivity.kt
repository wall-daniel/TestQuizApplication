package com.example.testapplication

import android.os.Bundle
import android.os.Process
import android.support.constraint.ConstraintLayout
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity;
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import kotlin.random.Random

class QuizActivity : AppCompatActivity(), QuestionFragment.OnButtonSelectedListener, AnswerFragment.OnClickLinearLayout {



    lateinit var constraintLayout: LinearLayout
    lateinit var questionFragment: QuestionFragment
    lateinit var answerFragment: AnswerFragment
    lateinit var fragmentManager: FragmentManager
    private var switched = true

    private lateinit var random: Random

    private var questions: List<Question>? = null

    private var answerButtonId: Int = R.id.button_A

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_default)
        constraintLayout = findViewById(R.id.constraint_layout)

        // Fragment question stuff
        fragmentManager = supportFragmentManager
        questionFragment = QuestionFragment()
        questionFragment.callback = this
        answerFragment = AnswerFragment()
        answerFragment.callback = this
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.constraint_layout, questionFragment)
        fragmentTransaction.commit()
    }

    fun changeQuestions() {
        // TODO
    }

    fun switchFragmentView() {
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.setCustomAnimations(R.anim.abc_grow_fade_in_from_bottom, R.anim.abc_popup_exit)

        fragmentTransaction.replace(R.id.constraint_layout, if(switched) answerFragment else questionFragment)
        switched = !switched

        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

    override fun onButtonSelected(buttonId: Int?) {
        if(buttonId == answerButtonId) {
            switchFragmentView()
        } else {
            // TODO
        }
    }

    override fun switchQuestion() {
        // TODO: change question

        switchFragmentView()
    }
}
