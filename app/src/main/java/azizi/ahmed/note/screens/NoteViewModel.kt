package azizi.ahmed.note.screens

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import azizi.ahmed.note.model.Note

class NoteViewModel: ViewModel() {
    private var noteList = mutableStateListOf<Note>()

    fun addNote(note: Note) {
        noteList.add(note)
    }

    fun removeNote(note: Note) {
        noteList.remove(note)
    }

    fun getAllNotes(): List<Note> {
        return noteList
    }
}