package com.example.mynotesapp.di

import android.app.Application
import androidx.room.Room
import com.example.mynotesapp.feature_note.data.data_source.NoteDatabase
import com.example.mynotesapp.feature_note.data.repository.NoteRepositoryImpl
import com.example.mynotesapp.feature_note.domain.model.Note
import com.example.mynotesapp.feature_note.domain.repository.NoteRepository
import com.example.mynotesapp.feature_note.domain.use_case.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideNotesDatabase(app: Application): NoteDatabase = Room.databaseBuilder(
        app,
        NoteDatabase::class.java,
        "notes_database"
    ).build()

    @Singleton
    @Provides
    fun provideRepository(db: NoteDatabase): NoteRepository = NoteRepositoryImpl(db.noteDao)

    @Singleton
    @Provides
    fun provideUseCasesWrapper(repository: NoteRepository): UseCasesWrapper {
        return UseCasesWrapper(
            getNotesUseCase = GetNotesUseCase(repository),
            deleteNoteUseCase = DeleteNoteUseCase(repository),
            addNoteUseCase = AddNoteUseCase(repository),
            getNoteUseCase = GetNoteUseCase(repository)
        )
    }

}