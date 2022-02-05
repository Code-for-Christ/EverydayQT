package com.jinyeob.eqt
import kotlinx.serialization.*

@Serializable
data class Verse (
    val verse: Long,
    val content: String
)
