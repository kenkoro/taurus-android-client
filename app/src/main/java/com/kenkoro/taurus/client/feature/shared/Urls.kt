package com.kenkoro.taurus.client.feature.shared

object Urls {
  private const val HOME_HOST = "192.168.0.112"
  private const val HOST = "10.10.114.82"
  private const val PROTOCOL = "http"
  private const val PORT = 8080
  private const val URL = "$PROTOCOL://$HOME_HOST:$PORT"

  const val LOGIN = "$URL/login"

  const val ADD_NEW_ORDER = "$URL/add-new/order"
  const val GET_ORDER = "$URL/order"
  const val GET_PAGINATED_ORDERS = "$URL/orders"
  const val EDIT_ORDER = "$URL/edit/order"
  const val DELETE_ORDER = "$URL/delete/order"

  const val ADD_NEW_USER = "$URL/add-new/user"
  const val GET_USER = "$URL/user"
  const val EDIT_USER = "$URL/edit/user"
  const val DELETE_USER = "$URL/delete/user"
}