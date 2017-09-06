package com.example.cleancalc

class Calculator {
    fun add(addend1: Int, addend2: Int): Int {
        return addend1 + addend2
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
