package com.example.cleancalc

class MainPresenter(private val controller: MainController) {
    fun onAddButtonClick(input_1: String, input_2: String) {
        val calculator = Calculator()
        val result = calculator.add(
                input_1.toInt(),
                input_2.toInt())
        controller.setResultText(result.toString())

        val category = calculator.getResultCategory(result)
        val color = if (category == Category.HIGH)
            Color.GREEN else Color.RED
        controller.setResultColor(color)
    }
}

enum class Color() {
    RED,
    GREEN
}
