package com.kenkoro.taurus.client.feature.sewing.domain.model

import com.kenkoro.taurus.client.feature.sewing.domain.model.enums.OrderStatus
import kotlinx.serialization.Serializable

@Serializable
data class Order(
  val recordId: Int,
  val orderId: Int,
  val customer: String,
  val date: Long,
  val title: String,
  val model: String,
  val size: String,
  val color: String,
  val category: String,
  val quantity: Int,
  val status: OrderStatus,
  val creatorId: Int,
)