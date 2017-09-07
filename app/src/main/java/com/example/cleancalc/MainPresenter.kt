package com.example.cleancalc

import android.databinding.ObservableInt

class MainPresenter(private val controller: MainController) {
    private val result = Result(ObservableInt(0))

    init {
        controller.bindData(result)
    }

    fun onAddButtonClick(input_1: String, input_2: String) {
        val calculator = Calculator()
        result.value.set(calculator.add(
                input_1.toInt(),
                input_2.toInt()))

        val category = calculator
                .getResultCategory(result.value.get())
        val color = if (category == Category.HIGH)
            Color.GREEN else Color.RED
        controller.setResultColor(color)
    }
}

enum class Color {
    RED,
    GREEN
}
