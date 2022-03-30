package com.jinyeob.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jinyeob.data.model.MccheyneCheckEntity
import com.jinyeob.data.model.MccheyneLocalDataSource

@Database(
    version = 1,
    entities = [MccheyneCheckEntity::class]
)

internal abstract class MyDatabase : RoomDatabase() {
    abstract fun getMccheyneLocalDataSource(): MccheyneLocalDataSource
}
