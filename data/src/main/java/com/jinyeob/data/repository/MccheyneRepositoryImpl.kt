package com.jinyeob.data.repository

import android.util.Log
import com.jinyeob.data.model.MccheyneAssetDataSource
import com.jinyeob.domain.model.MccheyneItem
import com.jinyeob.domain.repository.MccheyneRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

internal class MccheyneRepositoryImpl @Inject constructor(
    private val mccheyneAssetDataSource: MccheyneAssetDataSource
) : MccheyneRepository {
    override fun getMccheyneItems(): Flow<MccheyneItem> = flow{
        val mccheyneItem = mccheyneAssetDataSource.getMccheyneItems() ?: MccheyneItem()
        emit(mccheyneItem)
    }
}
