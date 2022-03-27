package com.jinyeob.data.model

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
internal interface MccheyneLocalDataSource {
    @Query("SELECT * FROM mccheyneItem")
    fun selectAll(): Flow<List<MccheyneItemEntity>>
}
