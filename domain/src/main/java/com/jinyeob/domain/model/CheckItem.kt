package com.jinyeob.domain.model

data class CheckItem(
    val isChecked: Boolean,
    val book: String,
    val chapter: Long,
    val verses: List<VerseItem>
)
