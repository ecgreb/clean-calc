package com.example.cleancalc

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.add_button
import kotlinx.android.synthetic.main.activity_main.toolbar
import kotlinx.android.synthetic.main.content_main.input_text_1
import kotlinx.android.synthetic.main.content_main.input_text_2
import kotlinx.android.synthetic.main.content_main.result_text

class MainActivity : AppCompatActivity(), MainController {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val presenter = MainPresenter(this)
        add_button.setOnClickListener {
            presenter.onAddButtonClick(
                    input_text_1.text.toString(),
                    input_text_2.text.toString())
        }
    }

    override fun setResultText(text: String) {
        result_text.text = text
    }

    override fun setResultColor(color: Color) {
        val colorInt = if (color == Color.GREEN)
            getColor(R.color.green) else getColor(R.color.red)
        result_text.setTextColor(colorInt)
    }
}

interface MainController {
    fun setResultText(text: String)
    fun setResultColor(color: Color)
}