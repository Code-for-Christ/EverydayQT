package com.jinyeob.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "mccheyneItem")
internal data class MccheyneItemEntity(
    @PrimaryKey(autoGenerate = true) val id: Int
)
