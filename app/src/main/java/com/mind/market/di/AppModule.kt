package com.mind.market.di

import android.app.Application
import androidx.room.Room
import com.mind.market.notes.feature_note.data.data_source.NoteDatabase
import com.mind.market.notes.feature_note.data.repository.NoteRepository
import com.mind.market.notes.feature_note.domain.repository.INoteRepository
import com.mind.market.notes.feature_note.domain.use_case.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideNoteDatabase(app: Application): NoteDatabase {
        return Room.databaseBuilder(
            app,
            NoteDatabase::class.java,
            NoteDatabase.DATABASE_NAME
        ).build()
    }
}

@Provides
@Singleton
fun provideNoteRepository(database: NoteDatabase): INoteRepository {
    return NoteRepository(database.noteDao)
}

@Provides
@Singleton
fun provideNoteUseCases(repository: INoteRepository): NoteUseCases {
    return NoteUseCases(
        getNotesUseCase = GetNotesUseCase(repository),
        deleteNoteUseCase = DeleteNoteUseCase(repository),
        addNoteUseCase = AddNoteUseCase(repository),
        getNoteByIdUseCase = GetNoteByIdUseCase(repository)
    )
}