package com.mind.market.notes.feature_note.presentation.notes

import com.mind.market.notes.feature_note.domain.model.Note
import com.mind.market.notes.feature_note.domain.util.NoteOrder

sealed class NotesEvent {
    data class DeleteNote(val note: Note) : NotesEvent()
    data class Order(val noteOrder: NoteOrder) : NotesEvent()
    object RestoreNote : NotesEvent()
    object ToggleOrderSection:NotesEvent()
}