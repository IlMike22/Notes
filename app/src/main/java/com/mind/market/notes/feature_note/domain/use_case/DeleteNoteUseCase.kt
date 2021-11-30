package com.mind.market.notes.feature_note.domain.use_case

import com.mind.market.notes.feature_note.domain.model.Note
import com.mind.market.notes.feature_note.domain.repository.INoteRepository

class DeleteNoteUseCase(
    private val repository:INoteRepository
) {
    suspend operator fun invoke(note: Note) {
        repository.deleteNote(note)
    }
}