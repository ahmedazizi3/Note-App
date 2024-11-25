package azizi.ahmed.note.data

import azizi.ahmed.note.model.Note

class NoteData {
    fun loadNotes(): List<Note> {
        return listOf(
            Note(title = "Note 1", details = "This is the first note"),
            Note(title = "Note 2", details = "This is the second note"),
            Note(title = "Note 3", details = "This is the third note"),
            Note(title = "Note 4", details = "This is the fourth note"),
            Note(title = "Note 5", details = "This is the fifth note"),
            Note(title = "Note 6", details = "This is the sixth note"),
            Note(title = "Note 7", details = "This is the seventh note"),
            Note(title = "Note 8", details = "This is the eighth note"),
            Note(title = "Note 9", details = "This is the ninth note"),
            Note(title = "Note 10", details = "This is the tenth note"),
            Note(title = "Note 11", details = "This is the eleventh note"),
            Note(title = "Note 12", details = "This is the twelfth note"),
            Note(title = "Note 13", details = "This is the thirteenth note"),
            Note(title = "Note 14", details = "This is the fourteenth note"),
            Note(title = "Note 15", details = "This is the fifteenth note"),
        )
    }
}