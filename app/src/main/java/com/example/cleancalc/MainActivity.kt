package com.example.cleancalc

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.cleancalc.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.toolbar
import kotlinx.android.synthetic.main.content_main.result_text

class MainActivity : AppCompatActivity(), MainController {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil
                .setContentView(this, R.layout.activity_main)

        setSupportActionBar(toolbar)

        val presenter = MainPresenter(this)
        binding.presenter = presenter
    }

    override fun bindData(result: Result) {
        binding.result = result
    }

    override fun setResultColor(color: Color) {
        val colorInt = if (color == Color.GREEN)
            getColor(R.color.green) else getColor(R.color.red)
        result_text.setTextColor(colorInt)
    }
}

interface MainController {
    fun bindData(result: Result)
    fun setResultColor(color: Color)
}
