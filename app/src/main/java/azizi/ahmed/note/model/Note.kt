package azizi.ahmed.note.model

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDateTime
import java.util.UUID

data class Note(
    @RequiresApi(Build.VERSION_CODES.O)
    val id: UUID = UUID.randomUUID(),
    val title: String,
    val details: String
)