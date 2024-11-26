package azizi.ahmed.note

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import azizi.ahmed.note.screens.NoteScreen
import azizi.ahmed.note.screens.NoteViewModel
import azizi.ahmed.note.ui.theme.NoteTheme
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val noteViewModel: NoteViewModel = viewModel()
            NoteTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val noteList = noteViewModel.getAllNotes()

                    NoteScreen(
                        notes = noteList,
                        onAddNote = {
                            noteViewModel.addNote(it)
                        },
                        onRemoveNote = {
                            noteViewModel.removeNote(it)
                        }

                    )
                }
            }
        }
    }
}

