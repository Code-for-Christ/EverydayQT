package com.jinyeob.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "mccheynecheck")
internal data class MccheyneCheckEntity(
    @PrimaryKey(autoGenerate = true) val id: Long
)
