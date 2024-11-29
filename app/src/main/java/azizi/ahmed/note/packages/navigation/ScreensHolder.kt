package azizi.ahmed.note.packages.navigation

sealed class ScreensHolder(
    val route: String
) {
    object NoteScreen: ScreensHolder("noteScreen")
    object AddingNoteScreen: ScreensHolder("addingNoteScreen")
}