package com.jinyeob.domain.repository

import com.jinyeob.domain.model.MccheyneItem
import kotlinx.coroutines.flow.Flow

interface MccheyneRepository {
    fun getMccheyneItems(): Flow<MccheyneItem>
}
