package com.example.testapplication

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class QuestionFragment: Fragment(), View.OnClickListener {

    lateinit var buttonA: Button
    lateinit var buttonB: Button
    lateinit var buttonC: Button
    lateinit var buttonD: Button

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var fragmentView: View = inflater.inflate(R.layout.fragment_question, container, false)

        // Button stuff
        buttonA = fragmentView.findViewById(R.id.button_A)
        buttonB = fragmentView.findViewById(R.id.button_B)
        buttonC = fragmentView.findViewById(R.id.button_C)
        buttonD = fragmentView.findViewById(R.id.button_D)
        buttonA.setOnClickListener(this)
        buttonB.setOnClickListener(this)
        buttonC.setOnClickListener(this)
        buttonD.setOnClickListener(this)

        return fragmentView
    }

    override fun onClick(v: View?) {
        callback.onButtonSelected(v?.id)
    }


    lateinit var callback: OnButtonSelectedListener

    interface OnButtonSelectedListener {
        fun onButtonSelected(buttonId: Int?)
    }

}