package com.kenkoro.taurus.client.feature.sewing.data.source.repository

import com.kenkoro.taurus.client.feature.sewing.data.source.remote.api.OrderApi
import com.kenkoro.taurus.client.feature.sewing.data.source.remote.dto.request.OrderRequestDto
import com.kenkoro.taurus.client.feature.sewing.data.source.remote.dto.request.UpdateRequestDto
import com.kenkoro.taurus.client.feature.sewing.data.util.OrderDataType
import io.ktor.client.statement.HttpResponse

class OrderRepositoryImpl(
  private val orderApi: OrderApi,
) : OrderRepository {
  fun token(token: String): OrderRepository {
    OrderApi.token(token)
    return this
  }

  override suspend fun newOrder(request: OrderRequestDto): HttpResponse {
    return orderApi.newOrder(request)
  }

  override suspend fun getOrder(orderId: Int): HttpResponse {
    return orderApi.getOrder(orderId)
  }

  override suspend fun getOrders(
    page: Int,
    perPage: Int,
  ): HttpResponse {
    return orderApi.getOrders(page, perPage)
  }

  override suspend fun updateOrderData(
    request: UpdateRequestDto,
    orderId: Int,
    data: OrderDataType,
  ): HttpResponse {
    return orderApi.updateOrderData(request, orderId, data)
  }

  override suspend fun deleteOrder(orderId: Int): HttpResponse {
    return orderApi.deleteOrder(orderId)
  }
}