package azizi.ahmed.note.packages.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID


@Entity(tableName = "NotesTable")
data class Note(
    @PrimaryKey
    val id: UUID = UUID.randomUUID(),

    @ColumnInfo(name = "NoteTitle")
    val title: String,

    @ColumnInfo(name = "NoteDetails")
    val details: String
)