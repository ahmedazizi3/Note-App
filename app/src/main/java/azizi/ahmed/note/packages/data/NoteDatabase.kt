package azizi.ahmed.note.packages.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import azizi.ahmed.note.packages.model.Note
import azizi.ahmed.note.packages.util.IdConverter


@Database(entities = [Note::class], version = 1, exportSchema = false)
@TypeConverters(IdConverter::class)
abstract class NoteDatabase: RoomDatabase() {
    abstract fun noteDao(): NoteDatabaseDao

}