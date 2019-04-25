package com.example.testapplication

import android.content.Context
import android.util.Log
import com.beust.klaxon.Json
import com.beust.klaxon.Klaxon
import com.beust.klaxon.json
import java.io.File

data class Question(
    val question: String,
    val answers: MutableList<Answer>)

data class Answer(val correct: Boolean, val answer: String) {

}

const val QUESTION_FILE: String = "questions.json"

fun loadQuestions(filesDir: File, filename: String): List<Question>? {
//    var questions = Klaxon().parse<List<Question>>(File(filesDir, filename)
//
//    return questions

    return listOf<Question>(
        Question("First question", mutableListOf<Answer>(Answer(true, "one"), Answer(false, "two"), Answer(false, "three"), Answer(false, "four"))),
        Question("Second question", mutableListOf<Answer>(Answer(true, "ones"), Answer(false, "twos"), Answer(false, "threes"), Answer(false, "fours")))
    )
}

fun writeQuestions(context: Context, filename: String) {
    var questions = listOf<Question>(
        Question("First question", mutableListOf<Answer>(Answer(true, "one"), Answer(false, "two"), Answer(false, "three"), Answer(false, "four"))),
        Question("Second question", mutableListOf<Answer>(Answer(true, "ones"), Answer(false, "twos"), Answer(false, "threes"), Answer(false, "fours")))
    )

    val logic = json {
        questions
    }

    Log.d("testubng", logic.toString())

    context.openFileOutput(filename, Context.MODE_PRIVATE).use {
        it.write(logic.toString().toByteArray())
    }
}