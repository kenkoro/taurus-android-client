package com.kenkoro.taurus.client.feature.orders.presentation.screen.order.components.bars

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.kenkoro.taurus.client.R
import com.kenkoro.taurus.client.core.connectivity.NetworkStatus
import com.kenkoro.taurus.client.core.local.LocalContentHeight
import com.kenkoro.taurus.client.core.local.LocalContentWidth
import com.kenkoro.taurus.client.core.local.LocalShape
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun OrderBottomBar(
  modifier: Modifier = Modifier,
  networkStatus: NetworkStatus,
  isScrollingInProgress: Boolean = false,
  onAddNewOrderShowSnackbar: suspend () -> SnackbarResult,
) {
  val shape = LocalShape.current
  val contentWidth = LocalContentWidth.current
  val contentHeight = LocalContentHeight.current
  val scope = rememberCoroutineScope()

  val animatedHeight by animateDpAsState(
    targetValue =
      if (isScrollingInProgress) {
        contentHeight.none
      } else {
        contentHeight.bottomBar
      },
    label = "AnimatedHeight",
  )

  Column(
    modifier =
      modifier
        .fillMaxWidth()
        .height(animatedHeight),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center,
  ) {
    Button(
      modifier =
        Modifier
          .width(contentWidth.orderItem)
          .height(contentHeight.halfStandard),
      onClick = { scope.launch(Dispatchers.Main) { onAddNewOrderShowSnackbar() } },
      shape = RoundedCornerShape(shape.medium),
    ) {
      Row(
        modifier = Modifier.fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
      ) {
        Icon(imageVector = Icons.Default.AddCircle, contentDescription = "AddANewOrder")
        Spacer(modifier = Modifier.width(contentWidth.medium))
        Text(text = stringResource(id = R.string.new_order_button))
      }
    }
  }
}