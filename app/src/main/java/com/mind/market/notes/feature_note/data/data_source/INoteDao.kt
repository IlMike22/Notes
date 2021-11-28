package com.mind.market.notes.feature_note.data.data_source

import androidx.room.*
import com.mind.market.notes.feature_note.domain.model.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface INoteDao {
    @Query("SELECT * FROM note")
    fun getNotes(): Flow<List<Note>>

    @Query("SELECT * FROM note WHERE note.id = :id")
    suspend fun getNoteById(id:Int):Note?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note:Note)

    @Delete
    suspend fun deleteNote(note:Note)
}