package com.mind.market.notes.feature_note.domain.use_case

import com.mind.market.notes.feature_note.domain.model.Note
import com.mind.market.notes.feature_note.domain.repository.INoteRepository

class GetNoteByIdUseCase(
    private val repository: INoteRepository
) {
    suspend operator fun invoke(noteId: Int): Note? {
        return repository.getNoteById(noteId)
    }
}