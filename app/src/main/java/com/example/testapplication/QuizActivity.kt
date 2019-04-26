package com.example.testapplication

import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import android.widget.LinearLayout
import java.util.concurrent.ThreadLocalRandom

class QuizActivity : AppCompatActivity(), QuestionFragment.OnButtonSelectedListener, AnswerFragment.OnClickLinearLayout {

    lateinit var constraintLayout: LinearLayout
    lateinit var questionFragment: QuestionFragment
    lateinit var answerFragment: AnswerFragment
    lateinit var fragmentManager: FragmentManager
    private var switched = false

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

        // Set the question on display fragment of question
        switchFragmentView()
    }

    fun changeQuestions() {
        questionFragment.setQuestion("This is the question", ThreadLocalRandom.current().nextInt().toString(), "B", "C", "D")
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
        switchFragmentView()

        changeQuestions()
//        Handler().postDelayed({
//            changeQuestions()
//        }, 1)
    }
}
