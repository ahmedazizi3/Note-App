package azizi.ahmed.note.packages.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import azizi.ahmed.note.packages.model.Note
import kotlinx.coroutines.flow.Flow


@Dao
interface NoteDatabaseDao {
    @Query("select * from NotesTable")
    fun getAllNotes(): Flow<List<Note>>

    @Query("select * from NotesTable where id = :id")
    suspend fun getNoteById(id: String): Note

    @Query("delete from NotesTable")
    suspend fun deleteAllNotes()

    @Delete
    suspend fun deleteNote(note: Note)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateNote(note: Note)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addNote(note: Note)

}