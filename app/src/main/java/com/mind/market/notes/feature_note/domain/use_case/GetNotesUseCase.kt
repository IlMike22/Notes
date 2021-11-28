package com.mind.market.notes.feature_note.domain.use_case

import com.mind.market.notes.feature_note.domain.model.Note
import com.mind.market.notes.feature_note.domain.repository.INoteRepository
import kotlinx.coroutines.flow.Flow

class GetNotesUseCase(
    private val repository:INoteRepository
) {
    operator fun invoke(): Flow<List<Note>> {

    }
}