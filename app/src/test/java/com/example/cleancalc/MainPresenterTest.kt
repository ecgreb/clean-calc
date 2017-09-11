package com.example.cleancalc

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class MainPresenterTest {
    private val controller = TestMainController()
    private val presenter = MainPresenter(controller)

    @Test
    fun onTextChanged_shouldSetResultTextPositive() {
        presenter.onInput1TextChanged("3", 0, 0, 0)
        presenter.onInput2TextChanged("4", 0, 0, 0)
        assertThat(controller.result?.value?.get()).isEqualTo(7)
    }

    @Test
    fun onTextChanged_shouldSetResultTextNegative() {
        presenter.onInput1TextChanged("2", 0, 0, 0)
        presenter.onInput2TextChanged("-3", 0, 0, 0)
        assertThat(controller.result?.value?.get()).isEqualTo(-1)
    }

    @Test
    fun onTextChanged_shouldSetResultColorPositive() {
        presenter.onInput1TextChanged("3", 0, 0, 0)
        presenter.onInput2TextChanged("4", 0, 0, 0)
        assertThat(controller.color).isEqualTo(Color.GREEN)
    }

    @Test
    fun onTextChanged_shouldSetResultColorNegative() {
        presenter.onInput1TextChanged("2", 0, 0, 0)
        presenter.onInput2TextChanged("-3", 0, 0, 0)
        assertThat(controller.color).isEqualTo(Color.RED)
    }
}

class TestMainController : MainController {
    var result: Result? = null
    var color: Color? = null

    override fun bindData(result: Result) {
        this.result = result
    }

    override fun setResultColor(color: Color) {
        this.color = color
    }
}
