package com.jinyeob.domain.repository

import com.jinyeob.domain.model.MccheyneItems
import kotlinx.coroutines.flow.Flow

interface MccheyneRepository {
    fun getMccheyneItems(): Flow<MccheyneItems>
}
