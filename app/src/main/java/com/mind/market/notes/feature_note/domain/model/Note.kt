package com.mind.market.notes.feature_note.domain.model

import androidx.room.PrimaryKey

data class Note(
    val title:String,
    val content:String,
    val timeStamp:Long,
    val color:Int,
    @PrimaryKey val id:Int? = null
) {
    companion object {
        val noteColors = listOf("RedOrange", "LightGreen")
    }
}
