package com.esslinger.msu.geoquizhw3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.esslinger.msu.geoquizhw3.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    private lateinit var binding :ActivityMainBinding

    private val questionBank = listOf(
        Question(R.string.question_australia, answer = true),
        Question(R.string.question_oceans, answer = true),
        Question(R.string.question_mideast, answer = false),
        Question(R.string.question_africa, answer = false),
        Question(R.string.question_americas, answer = true),
        Question(R.string.question_asia,answer = true)
    )
    private var currentIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate (Bundle?) called")
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.trueButton.setOnClickListener { view: View ->
            Snackbar.make(
                view,
                R.string.correct_snackbar,
                Snackbar.LENGTH_SHORT
            ).show()
        }

        binding.falseButton.setOnClickListener { view: View ->
            Snackbar.make(
                view,
                R.string.incorrect_snackbar,
                Snackbar.LENGTH_SHORT
            ).show()
        }

        binding.questionTextview.setOnClickListener {
            currentIndex = (currentIndex + 1) % questionBank.size
            updateQuestion()
        }

        binding.nextButton.setOnClickListener {
            currentIndex = (currentIndex + 1) % questionBank.size
            updateQuestion()
        }

        binding.previousButton.setOnClickListener {
            currentIndex = (currentIndex - 1 + questionBank.size) % questionBank.size
            updateQuestion()
        }

        updateQuestion()
    }

    private fun updateQuestion() {
        val questionTextResId = questionBank[currentIndex].textResId
        binding.questionTextview.setText(questionTextResId)
    }

    override fun onStart(){
        super.onStart()
        Log.d(TAG, "onStart() called")
    }
    override fun onResume(){
        super.onResume()
        Log.d(TAG, "onResume() called")
    }
    override fun onPause(){
        super.onPause()
        Log.d(TAG, "onPause() called")
    }
    override fun onStop(){
        super.onStop()
        Log.d(TAG, "onStop() called")
    }
    override fun onDestroy(){
        super.onDestroy()
        Log.d(TAG, "onDestroy() called")
    }
}
