package azizi.ahmed.noteapp.packages.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import azizi.ahmed.noteapp.packages.model.Note
import kotlinx.coroutines.flow.Flow


@Dao
interface NoteDao {

//    Create Note
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addNote(note: Note)

//    Read All notes
    @Query("select * from NotesTable")
    fun getAllNotes(): Flow<List<Note>>

//    Update Note
    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateNote(note: Note)

//    Delete Note
    @Delete
    suspend fun deleteNote(note: Note)

}