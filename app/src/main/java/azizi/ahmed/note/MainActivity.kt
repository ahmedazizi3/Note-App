package azizi.ahmed.note

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import azizi.ahmed.note.model.Note
import azizi.ahmed.note.screens.NoteScreen
import azizi.ahmed.note.ui.theme.NoteTheme
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NoteTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    var note = remember {
                        mutableStateListOf<Note>()
                    }

                    NoteScreen(
                        notes = note,
                        onAddNote = {
                            note.add(
                                it
                            )
                        },
                        onRemoveNote = {}
                    )
                }
            }
        }
    }
}
