package com.kenkoro.taurus.client.feature.orders.presentation.screen.editor.order.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.kenkoro.taurus.client.core.connectivity.NetworkStatus
import com.kenkoro.taurus.client.core.local.LocalContentHeight
import com.kenkoro.taurus.client.core.local.LocalContentWidth
import com.kenkoro.taurus.client.feature.orders.presentation.screen.editor.order.util.OrderIdState
import com.kenkoro.taurus.client.ui.theme.AppTheme

@Composable
fun OrderEditorContent(
  modifier: Modifier = Modifier,
  networkStatus: NetworkStatus,
  orderIdState: OrderIdState = OrderIdState(),
) {
  val contentWidth = LocalContentWidth.current
  val contentHeight = LocalContentHeight.current

  Column(
    modifier = modifier.fillMaxWidth(),
    verticalArrangement = Arrangement.Top,
    horizontalAlignment = Alignment.CenterHorizontally,
  ) {
    Spacer(modifier = Modifier.height(contentHeight.large))
    OrderEditorTextFields(
      modifier = Modifier.width(contentWidth.standard),
      orderIdState = orderIdState,
    )
  }
}

@Preview(showBackground = true)
@Composable
private fun OrderEditorContentPrev() {
  AppTheme {
    OrderEditorContent(networkStatus = NetworkStatus.Available)
  }
}