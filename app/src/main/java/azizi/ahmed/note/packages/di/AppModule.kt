package azizi.ahmed.note.packages.di

import android.content.Context
import androidx.room.Room
import azizi.ahmed.note.packages.data.NoteDatabase
import azizi.ahmed.note.packages.data.NoteDatabaseDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideNoteDatabaseDao(noteDatabase: NoteDatabase): NoteDatabaseDao = noteDatabase.noteDao()

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