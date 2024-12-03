package azizi.ahmed.note.packages.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import azizi.ahmed.note.packages.model.Note
import azizi.ahmed.note.packages.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(private val repository: NoteRepository) : ViewModel() {

    private val _noteList = MutableStateFlow<List<Note>>(emptyList())
    val noteList = _noteList.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAllNotes().collect { listOfNotes ->
                _noteList.value = listOfNotes
            }
        }
    }

    fun addNote(note: Note) {
        viewModelScope.launch {
            repository.addNote(note)
        }
    }

    fun updateNote(note: Note) {
        viewModelScope.launch {
            repository.updateNote(note)  // Ensure this method updates the note in the database
        }
    }

    fun deleteNote(note: Note) {
        viewModelScope.launch {
            repository.deleteNote(note)
        }
    }

    fun getNoteById(noteId: String?): Note? {
        return _noteList.value.find { it.id.toString() == noteId }
    }
}
