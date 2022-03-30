package com.jinyeob.data.model

import android.content.Context
import com.jinyeob.domain.model.MccheyneItem
import com.squareup.moshi.Moshi
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

internal class MccheyneAssetDataSource @Inject constructor(
    @ApplicationContext private val context: Context,
    moshi: Moshi
) {
    private val jsonAdapter = moshi.adapter(MccheyneItem::class.java)

    fun getMccheyneItems(): MccheyneItem? {
        val json = context.assets
            .open(FILE_NAME)
            .bufferedReader()
            .use { it.readText() }
        return jsonAdapter.fromJson(json)
    }

    companion object {
        private const val FILE_NAME = "plan.json"
    }
}
