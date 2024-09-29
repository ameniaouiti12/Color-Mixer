package com.example.test
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.test.databinding.ActivityAnswerBinding
import com.google.android.material.snackbar.Snackbar

class AnswerActivity : AppCompatActivity() {

    // TODO 12: Add lateinit var for binding
    private lateinit var binding: ActivityAnswerBinding

    private var correctColor = "NONE"
    private var name = "NONE"
    private var color1 = "NONE"
    private var color2 = "NONE"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO 13: Bind the view and implement setContentView()
        binding = ActivityAnswerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // TODO 14: Change the value of correctColor / name / color1 / color2 with the DATA from the INTENT
        name = intent.getStringExtra(NAME) ?: "NONE"
        color1 = intent.getStringExtra(COLOR1) ?: "NONE"
        color2 = intent.getStringExtra(COLOR2) ?: "NONE"
        correctColor = intent.getStringExtra(MIXED_COLOR) ?: "NONE"

        // TODO 15: Change the txtChoosed with : "You chose $color1 and $color2"
        binding.txtChoosed.text = "You chose $color1 and $color2"

        // TODO 16: Implement setOnClickListener on the btnSubmit and call checkAnswer()
        binding.btnSubmit.setOnClickListener {
            if (checkAnswer()) {
                // If correct, navigate to ResultActivity with SUCCESS
                navigateToResultActivity(SUCCESS)
            } else {
                // If incorrect, navigate to ResultActivity with FAILED
                navigateToResultActivity(FAILED)
            }
        }
    }

    private fun checkAnswer(): Boolean {
        // TODO 17: Check if the answer of the chosen color is correct
        // Verify that only one radio button is selected
        val selectedColor = when {

            binding.cbPurple.isChecked -> PURPLE
            binding.cbGreen.isChecked -> GREEN
            binding.cbOrange.isChecked -> ORANGE
            else -> {
                Snackbar.make(binding.root, "Please select one color!", Snackbar.LENGTH_SHORT).show()
                return false
            }
        }

        // Check if the selected color matches the correct mixed color
        return selectedColor == correctColor
    }

    private fun navigateToResultActivity(result: String) {
        val intent = Intent(this, ResultActivity::class.java)
        intent.putExtra(NAME, name)
        intent.putExtra(RESULT, result)
        startActivity(intent)
    }
}
