package com.mind.market.notes.feature_note.domain.use_case

import com.mind.market.notes.feature_note.domain.model.InvalidNoteException
import com.mind.market.notes.feature_note.domain.model.Note
import com.mind.market.notes.feature_note.domain.repository.INoteRepository

class AddNoteUseCase(
    private val repository: INoteRepository
) {
    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: Note) {
        if (note.title.isBlank()) {
            throw InvalidNoteException("The title of the note must not be empty.")
        }
        if (note.content.isBlank()) {
            throw InvalidNoteException("The content of the note must not be empty.")
        }

        repository.insertNote(note)
    }
}