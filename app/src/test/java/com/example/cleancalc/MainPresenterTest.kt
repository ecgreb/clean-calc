package com.example.cleancalc

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class MainPresenterTest {
    private val controller = TestMainController()
    private val presenter = MainPresenter(controller)

    @Test
    fun onAddButtonClick_shouldSetResultTextPositive() {
        presenter.onAddButtonClick("3", "4")
        assertThat(controller.text).isEqualTo("7")
    }

    @Test
    fun onAddButtonClick_shouldSetResultTextNegative() {
        presenter.onAddButtonClick("2", "-3")
        assertThat(controller.text).isEqualTo("-1")
    }

    @Test
    fun onAddButtonClick_shouldSetResultColorPositive() {
        presenter.onAddButtonClick("3", "4")
        assertThat(controller.color).isEqualTo(Color.GREEN)
    }

    @Test
    fun onAddButtonClick_shouldSetResultColorNegative() {
        presenter.onAddButtonClick("2", "-3")
        assertThat(controller.color).isEqualTo(Color.RED)
    }
}

class TestMainController : MainController {
    var text: String? = null
    var color: Color? = null

    override fun setResultText(text: String) {
        this.text = text
    }

    override fun setResultColor(color: Color) {
        this.color = color
    }
}
