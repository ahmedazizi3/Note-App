package azizi.ahmed.noteapp.packages.di

import android.content.Context
import androidx.room.Room
import azizi.ahmed.noteapp.packages.data.NoteDatabase
import azizi.ahmed.noteapp.packages.data.NoteDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NoteAppModule {

    @Singleton
    @Provides
    fun provideNoteDao(noteDatabase: NoteDatabase): NoteDao = noteDatabase.noteDao()

    @Singleton
    @Provides
    fun provideNoteDatabase(@ApplicationContext context: Context): NoteDatabase =
        Room
            .databaseBuilder(
                context,
                NoteDatabase::class.java,
                "NotesDatabase"
            )
            .fallbackToDestructiveMigration()
            .build()

}