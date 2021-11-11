package com.example.mynotesapp.feature_note.data.repository

import com.example.mynotesapp.feature_note.data.data_source.NoteDao
import com.example.mynotesapp.feature_note.domain.model.Note
import com.example.mynotesapp.feature_note.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow

class NoteRepositoryImpl(
    private val noteDao: NoteDao
): NoteRepository {

    override fun getNotes(): Flow<List<Note>> = noteDao.getAllNotes()

    override suspend fun getNoteById(noteId: Int): Note? = noteDao.getNoteById(noteId)

    override suspend fun insertNote(note: Note) {
        noteDao.insertNote(note)
    }

    override suspend fun deleteNote(note: Note) {
        noteDao.deleteNote(note)
    }
}