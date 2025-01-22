package iu.b590.spring2025.lab1

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import iu.b590.spring2025.lab1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // Instead of multiple findViewById calls,
    // we use a single "binding" object from View Binding
    private lateinit var binding: ActivityMainBinding

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
        // Inflate the binding for activity_main.xml
        binding = ActivityMainBinding.inflate(layoutInflater)
        // Set the activity's content to the root of the binding
        setContentView(binding.root)

        // Display the first question text
        updateQuestion()

        // TRUE button listener
        binding.trueButton.setOnClickListener {
            checkAnswer(true)
        }

        // FALSE button listener
        binding.falseButton.setOnClickListener {
            checkAnswer(false)
        }

        // NEXT button listener
        binding.nextButton.setOnClickListener {
            currentIndex = (currentIndex + 1) % questionBank.size
            updateQuestion()
        }
    }

    private fun updateQuestion() {
        val questionTextResId = questionBank[currentIndex].textResId
        // Use binding to access the question_text_view
        binding.questionTextView.setText(questionTextResId)
    }

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
