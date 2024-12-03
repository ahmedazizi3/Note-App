package azizi.ahmed.note.packages.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import azizi.ahmed.note.packages.screens.AddingNoteScreen
import azizi.ahmed.note.packages.screens.EditScreen
import azizi.ahmed.note.packages.screens.NoteScreen
import azizi.ahmed.note.packages.view_model.NoteViewModel

@Composable
fun NoteNavigation() {
    val navController = rememberNavController()
    val noteViewModel: NoteViewModel = viewModel()
    val noteList = noteViewModel.noteList.collectAsState().value

    NavHost(
        navController = navController,
        startDestination = ScreensHolder.NoteScreen.route
    ) {
        composable(
            route = ScreensHolder.NoteScreen.route

        ) {
            NoteScreen(
                notes = noteList,
                onRemoveNote = {
                    noteViewModel.deleteNote(it)
                },
                navigateToEditNote = { note ->
                    navController.navigate(ScreensHolder.EditScreen.createRoute(note.id.toString()))
                }
            ) {
                navController.navigate(ScreensHolder.AddingNoteScreen.route)
            }
        }

        composable(
            route = ScreensHolder.AddingNoteScreen.route
        ) {
            AddingNoteScreen(
                onAddNote = {
                    noteViewModel.addNote(it)
                },
                navigateBack = {
                    navController.popBackStack()
                }
            )
        }

        composable(
            route = ScreensHolder.EditScreen.route
        ) { backStackEntry ->
            val noteId = backStackEntry.arguments?.getString("noteId") // Assuming you pass an ID
            val selectedNote = noteViewModel.getNoteById(noteId)

            if (selectedNote != null) {
                EditScreen(
                    note = selectedNote,
                    onEditNote = {
                        noteViewModel.updateNote(it)
                    },
                    navigateBack = {
                        navController.popBackStack()
                    }
                )
            }
        }

    }

}