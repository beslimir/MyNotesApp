package com.example.mynotesapp.feature_note.domain.use_case

data class UseCasesWrapper(
    val getNotesUseCase: GetNotesUseCase,
    val deleteNoteUseCase: DeleteNoteUseCase
)
