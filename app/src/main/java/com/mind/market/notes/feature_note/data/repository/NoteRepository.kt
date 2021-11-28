package com.mind.market.notes.feature_note.data.repository

import com.mind.market.notes.feature_note.data.data_source.INoteDao
import com.mind.market.notes.feature_note.domain.model.Note
import com.mind.market.notes.feature_note.domain.repository.INoteRepository
import kotlinx.coroutines.flow.Flow

class NoteRepository(
    private val noteDao: INoteDao
) : INoteRepository {
    override fun getNotes(): Flow<List<Note>> {
        return noteDao.getNotes()
    }

    override suspend fun getNoteById(id: Int): Note? {
        return noteDao.getNoteById(id)
    }

    override suspend fun insertNote(note: Note) {
        noteDao.insertNote(note)
    }

    override suspend fun deleteNote(note: Note) {
        noteDao.deleteNote(note)
    }
}