package com.jinyeob.eqt
import kotlinx.serialization.*

@Serializable
data class CheckItem (
    val isChecked: Boolean,
    val book: String,
    val chapter: Long,
    val verses: List<Verse>
)
