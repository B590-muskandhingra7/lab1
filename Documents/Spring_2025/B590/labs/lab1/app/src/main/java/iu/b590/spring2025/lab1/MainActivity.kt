package iu.b590.spring2025.lab1

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.enableEdgeToEdge

class MainActivity : AppCompatActivity() {

    private lateinit var trueButton: Button
    private lateinit var falseButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()  // optional, depending on your setup
        setContentView(R.layout.activity_main)

        // Find each Button by its ID
        trueButton = findViewById(R.id.true_button)
        falseButton = findViewById(R.id.false_button)

        // When the TRUE button is clicked:
        trueButton.setOnClickListener { view: View ->
            Toast.makeText(
                /* context = */ this,
                /* text = */ R.string.correct_toast,
                /* duration = */ Toast.LENGTH_SHORT
            ).show()
        }

        // When the FALSE button is clicked:
        falseButton.setOnClickListener { view: View ->
            Toast.makeText(
                this,
                R.string.incorrect_toast,
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}
