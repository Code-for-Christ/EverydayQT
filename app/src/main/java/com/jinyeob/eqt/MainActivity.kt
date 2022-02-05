package com.jinyeob.eqt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

class MainActivity : AppCompatActivity() {
    private lateinit var mccheynePlan: Plan

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        parseJson()
    }

    @ExperimentalSerializationApi
    fun parseJson() {
        val assetManager = this.resources.assets
        val inputStream = assetManager.open("jsons/plan.json")
        val jsonString = inputStream.bufferedReader().use { it.readText() }

        mccheynePlan = Json.decodeFromString(jsonString)
        mccheynePlan.plan.forEach { (key, value) -> println("$key = $value") }
    }
}
