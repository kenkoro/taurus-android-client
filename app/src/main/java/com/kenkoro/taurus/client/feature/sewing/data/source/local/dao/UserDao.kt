package com.kenkoro.taurus.client.feature.sewing.data.source.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.kenkoro.taurus.client.feature.sewing.data.source.local.UserEntity

@Dao
interface UserDao {
  @Upsert
  suspend fun upsert(userEntity: UserEntity)

  @Delete
  suspend fun delete(userEntity: UserEntity)

  @Query("select * from user_entities where user_id = :userId")
  suspend fun getUserById(userId: Int): UserEntity?

  @Query("select * from user_entities")
  suspend fun getUsers(): List<UserEntity>
}