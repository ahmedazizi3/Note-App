package azizi.ahmed.note.packages.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import azizi.ahmed.note.packages.screens.AddingNoteScreen
import azizi.ahmed.note.packages.screens.NoteScreen
import azizi.ahmed.note.packages.view_model.NoteViewModel

@Composable
fun Navigation() {
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
    }

}