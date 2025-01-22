package iu.b590.spring2025.lab1

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import iu.b590.spring2025.lab1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    // Example question bank referencing R.string.* resources
    private val questionBank = listOf(
        Question(R.string.question_australia, true),
        Question(R.string.question_oceans, true),
        Question(R.string.question_mideast, false),
        Question(R.string.question_africa, false),
        Question(R.string.question_americas, true),
        Question(R.string.question_asia, true)
    )

    private var currentIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Show the first question
        updateQuestion()

        // TRUE button listener
        binding.trueButton.setOnClickListener {
            // Instead of hardcoding a "correct" toast, we delegate to checkAnswer()
            checkAnswer(userAnswer = true)
        }

        // FALSE button listener
        binding.falseButton.setOnClickListener {
            checkAnswer(userAnswer = false)
        }

        // NEXT button listener (move to the next question in the list)
        binding.nextButton.setOnClickListener {
            currentIndex = (currentIndex + 1) % questionBank.size
            updateQuestion()
        }
    }

    /**
     * Updates the TextView to show the current question's text.
     */
    private fun updateQuestion() {
        val questionTextResId = questionBank[currentIndex].textResId
        binding.questionTextView.setText(questionTextResId)
    }

    /**
     * Compares the user's answer (true/false) against the question's correct answer.
     * Displays a toast message indicating "Correct" or "Incorrect."
     */
    private fun checkAnswer(userAnswer: Boolean) {
        val correctAnswer = questionBank[currentIndex].answer
        val messageResId = if (userAnswer == correctAnswer) {
            R.string.correct_toast
        } else {
            R.string.incorrect_toast
        }
        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show()
    }
}
