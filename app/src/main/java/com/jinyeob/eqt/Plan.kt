package com.jinyeob.eqt
import kotlinx.serialization.*

@Serializable
data class Plan (
    val plan: Map<String, List<CheckItem>>
)
