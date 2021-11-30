package com.mind.market.notes.feature_note.domain.use_case

data class NoteUseCases(
    val addNoteUseCase: AddNoteUseCase,
    val deleteNoteUseCase: DeleteNoteUseCase,
    val getNotesUseCase: GetNotesUseCase,
    val getNoteByIdUseCase: GetNoteByIdUseCase
)