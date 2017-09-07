package com.example.cleancalc

import android.databinding.ObservableInt

class MainPresenter(private val controller: MainController) {
    private val result = Result(ObservableInt(0))
    private val calculator = Calculator(result)

    init {
        controller.bindData(result)
    }

    fun onAddButtonClick() {
        val category = calculator
                .getResultCategory(result.value.get())
        val color = if (category == Category.HIGH)
            Color.GREEN else Color.RED
        controller.setResultColor(color)
    }

    fun onInput1TextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
        calculator.addend1 = if (!s.isEmpty()) s.toString().toInt() else 0
    }

    fun onInput2TextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
        calculator.addend2 = if (!s.isEmpty()) s.toString().toInt() else 0
    }
}

enum class Color {
    RED,
    GREEN
}
