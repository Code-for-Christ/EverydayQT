package com.jinyeob.eqt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.jinyeob.eqt.databinding.ActivityMainBinding
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import java.util.zip.Inflater

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mccheynePlan: Plan

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mccheynePlan = parseJson()

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = MccheyneReadRecyclerViewAdapter(mccheynePlan.plan)
    }

    @ExperimentalSerializationApi
    fun parseJson(): Plan {
        val assetManager = this.resources.assets
        val inputStream = assetManager.open("jsons/plan.json")
        val jsonString = inputStream.bufferedReader().use { it.readText() }

        return Json.decodeFromString(jsonString)
//        mccheynePlan.plan.forEach { (key, value) -> println("$key = $value") }
    }
}
