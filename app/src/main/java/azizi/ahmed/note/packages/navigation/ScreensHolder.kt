package azizi.ahmed.note.packages.navigation

sealed class ScreensHolder(
    val route: String
) {
    object NoteScreen: ScreensHolder("noteScreen")
    object AddingNoteScreen: ScreensHolder("addingNoteScreen")
    object EditScreen : ScreensHolder("editScreen/{noteId}") {
        fun createRoute(noteId: String): String = "editScreen/$noteId"
    }
}