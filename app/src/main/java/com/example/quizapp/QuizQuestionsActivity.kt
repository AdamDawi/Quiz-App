package com.example.quizapp

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat

class QuizQuestionsActivity : AppCompatActivity(), OnClickListener
{

    private var mCurrentPosition: Int =1
    private var mQuestionsList:ArrayList<Question>? = null
    private var mSelectedOptionPosition : Int = 0

    private var progressBar : ProgressBar? = null
    private var tvProgress : TextView? = null
    private var tvQuestion : TextView? = null
    private var ivImage : ImageView? = null

    private var tvOption1 : TextView? = null
    private var tvOption2 : TextView? = null
    private var tvOption3 : TextView? = null
    private var tvOption4 : TextView? = null
    private var btnSubmit : Button? = null

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        progressBar = findViewById(R.id.progressBar)
        tvProgress = findViewById(R.id.tvProgress)
        tvQuestion = findViewById(R.id.tvQuestion)
        ivImage = findViewById(R.id.ivImage)
        tvOption1 = findViewById(R.id.tvOption1)
        tvOption2 = findViewById(R.id.tvOption2)
        tvOption3 = findViewById(R.id.tvOption3)
        tvOption4 = findViewById(R.id.tvOption4)
        btnSubmit = findViewById(R.id.btnSumbit)

        tvOption1?.setOnClickListener(this)
        tvOption2?.setOnClickListener(this)
        tvOption3?.setOnClickListener(this)
        tvOption4?.setOnClickListener(this)
        btnSubmit?.setOnClickListener(this)

        mQuestionsList = Constants.getQuestions()

        setQuestion()


    }

    private fun setQuestion()
    {
        val question: Question? = mQuestionsList!![mCurrentPosition - 1]
        progressBar?.progress = mCurrentPosition
        tvProgress?.text = "$mCurrentPosition" + "/" + progressBar?.max
        tvQuestion?.text = question!!.question
        ivImage?.setImageResource(question.image)
        tvOption1?.text = question.optionOne
        tvOption2?.text = question.optionTwo
        tvOption3?.text = question.optionThree
        tvOption4?.text = question.optionFour
    }

    override fun onClick(view: View?)
    {
        when (view?.id) {

            R.id.tvOption1 -> {
                tvOption1?.let {
                    selectedOptionView(it, 1)
                }

            }

            R.id.tvOption2 -> {
                tvOption2?.let {
                    selectedOptionView(it, 2)
                }

            }

            R.id.tvOption3 -> {
                tvOption3?.let {
                    selectedOptionView(it, 3)
                }

            }

            R.id.tvOption4 -> {
                tvOption4?.let {
                    selectedOptionView(it, 4)
                }

            }

            R.id.btnSumbit -> {
                // TODO "implement"
                }

        }
    }

    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int) {

        defaultOptionsView()

        mSelectedOptionPosition = selectedOptionNum

        tv.setTextColor(
            Color.parseColor("#363A43")
        )
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_border_bg
        )
    }

    private fun defaultOptionsView() {

        val options = ArrayList<TextView>()
        tvOption1?.let {
            options.add(0, it)
        }
        tvOption2?.let {
            options.add(1, it)
        }
        tvOption3?.let {
            options.add(2, it)
        }
        tvOption4?.let {
            options.add(3,it)
        }

        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg
            )
        }
    }
}