package com.kenkoro.taurus.client.core.local

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class Arrangement(
  val standard: Dp = 10.dp,
)

val LocalArrangement = compositionLocalOf { Arrangement() }