package com.example.mynotesapp.feature_note.domain.use_case

import com.example.mynotesapp.feature_note.domain.model.Note
import com.example.mynotesapp.feature_note.domain.repository.NoteRepository

class GetNoteUseCase(
    private val noteRepository: NoteRepository
) {

    suspend operator fun invoke(noteId: Int): Note? = noteRepository.getNoteById(noteId)


}