package com.example.testapplication

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout

class AnswerFragment: Fragment() {

    lateinit var callback: OnClickLinearLayout

    fun setOnClickLinearLayout(callback: OnClickLinearLayout) {
        this.callback = callback
    }

    interface OnClickLinearLayout {
        fun switchQuestion()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var fragmentView: View = inflater.inflate(R.layout.fragment_answer, container, false)

        fragmentView.findViewById<LinearLayout>(R.id.answer_linear_layout).setOnClickListener {
            callback.switchQuestion()
        }

        return fragmentView
    }
}