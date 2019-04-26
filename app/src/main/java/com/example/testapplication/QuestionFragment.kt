package com.example.testapplication

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class QuestionFragment: Fragment(), View.OnClickListener {

    var questionText: TextView? = null
    var buttonA: Button? = null
    var buttonB: Button? = null
    var buttonC: Button? = null
    var buttonD: Button? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val fragmentView: View = inflater.inflate(R.layout.fragment_question, container, false)

        // Button stuff
        buttonA = fragmentView.findViewById(R.id.button_A)
        buttonB = fragmentView.findViewById(R.id.button_B)
        buttonC = fragmentView.findViewById(R.id.button_C)
        buttonD = fragmentView.findViewById(R.id.button_D)
        buttonA?.setOnClickListener(this)
        buttonB?.setOnClickListener(this)
        buttonC?.setOnClickListener(this)
        buttonD?.setOnClickListener(this)

        // Question text object
        questionText = fragmentView.findViewById(R.id.question_text)

        return fragmentView
    }

    override fun onClick(v: View?) {
        callback.onButtonSelected(v?.id)
    }

    fun setQuestion(question: String, answerA: String, answerB: String, answerC: String, answerD: String) {
        questionText?.setText(question)
        buttonA?.setText(answerA)
        buttonB?.setText(answerB)
        buttonC?.setText(answerC)
        buttonD?.setText(answerD)
    }

    lateinit var callback: OnButtonSelectedListener

    interface OnButtonSelectedListener {
        fun onButtonSelected(buttonId: Int?)
    }

}