package com.mind.market.notes.feature_note.domain.use_case

import com.mind.market.notes.feature_note.domain.model.Note
import com.mind.market.notes.feature_note.domain.repository.INoteRepository
import com.mind.market.notes.feature_note.domain.util.NoteOrder
import com.mind.market.notes.feature_note.domain.util.OrderType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetNotesUseCase(
    private val repository: INoteRepository
) {
    operator fun invoke(noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending)): Flow<List<Note>> {
        return repository.getNotes().map { notes ->
            when (noteOrder.orderType) {
                is OrderType.Ascending -> {
                    when (noteOrder) {
                        is NoteOrder.Date -> {
                            notes.sortedBy { note -> note.timeStamp }
                        }
                        is NoteOrder.Title -> {
                            notes.sortedBy { note -> note.title.lowercase() }
                        }
                        is NoteOrder.Color -> {
                            notes.sortedBy { note -> note.color }
                        }
                    }
                }
                is OrderType.Descending -> {
                    when (noteOrder) {
                        is NoteOrder.Date -> {
                            notes.sortedByDescending { note -> note.timeStamp }
                        }
                        is NoteOrder.Title -> {
                            notes.sortedByDescending { note -> note.title.lowercase() }
                        }
                        is NoteOrder.Color -> {
                            notes.sortedByDescending { note -> note.color }
                        }
                    }

                }
            }
        }
    }
}
