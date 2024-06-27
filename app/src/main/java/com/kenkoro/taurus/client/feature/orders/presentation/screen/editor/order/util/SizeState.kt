package com.kenkoro.taurus.client.feature.orders.presentation.screen.editor.order.util

import com.kenkoro.taurus.client.feature.shared.states.TaurusTextFieldState

class SizeState(
  size: String? = null,
) : TaurusTextFieldState(
    validator = ::isSizeValid,
    errorFor = ::sizeValidationError,
  ) {
  init {
    size?.let {
      text = it
    }
  }
}

private fun sizeValidationError(
  size: String,
  errorMessage: String,
): String {
  return "$size $errorMessage"
}

private fun isSizeValid(size: String): Boolean {
  return size.isNotBlank() && size.isAllLettersUppercase()
}

fun String.isAllLettersUppercase(): Boolean {
  this.forEach {
    if (!it.isUpperCase()) return false
  }
  return true
}