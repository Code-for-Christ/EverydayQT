package com.jinyeob.data.repository

import com.jinyeob.data.model.MccheyneLocalDataSource
import com.jinyeob.domain.model.MccheyneItems
import com.jinyeob.domain.repository.MccheyneRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

internal class MccheyneRepositoryImpl @Inject constructor(
    private val mccheyneLocalDataSource: MccheyneLocalDataSource
): MccheyneRepository {
    override fun getMccheyneItems(): Flow<MccheyneItems> {
        TODO("Not yet implemented")
    }
}
