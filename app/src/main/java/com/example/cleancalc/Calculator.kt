package com.example.cleancalc

class Calculator(var result: Result) {
    var addend1: Int = 0
        set(value) {
            field = value
            add()
        }

    var addend2: Int = 0
        set(value) {
            field = value
            add()
        }

    private fun add() {
        result.value.set(addend1 + addend2)
    }

    fun getResultCategory(result: Int): Category {
        return if (result < 0) Category.LOW else
            Category.HIGH
    }
}

enum class Category {
    LOW,
    HIGH
}
