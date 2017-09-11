package com.example.cleancalc

import android.databinding.ObservableInt

class MainPresenter(private val controller: MainController) {
    private val result = Result(ObservableInt(0), Category.HIGH)
    private val calculator = Calculator(result)

    init {
        controller.bindData(result)
    }

    fun onInput1TextChanged(s: CharSequence, start: Int,
            before: Int, count: Int) {
        calculator.addend1 = if (isNumber(s))
            s.toString().toInt() else 0
        controller.setResultColor(if (result.category == Category.HIGH)
            Color.GREEN else Color.RED)
    }

    fun onInput2TextChanged(s: CharSequence, start: Int,
            before: Int, count: Int) {
        calculator.addend2 = if (isNumber(s))
            s.toString().toInt() else 0
        controller.setResultColor(if (result.category == Category.HIGH)
            Color.GREEN else Color.RED)
    }

    private fun isNumber(s: CharSequence) =
            !s.isEmpty() && s.toString() != "-"
}

enum class Color {
    RED,
    GREEN
}
