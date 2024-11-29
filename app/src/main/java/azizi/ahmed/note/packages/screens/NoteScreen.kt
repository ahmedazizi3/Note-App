package azizi.ahmed.note.packages.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import azizi.ahmed.note.packages.components.NoteCard
import azizi.ahmed.note.packages.model.Note

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteScreen(
    modifier: Modifier = Modifier,
    notes: List<Note>,
    onRemoveNote: (Note) -> Unit = {},
    navigateToAddANote: () -> Unit = {}
) {
    val noteAppGrayColor: Color = Color(0xFF9199A0)


    Scaffold(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Notes",
                        fontWeight = FontWeight.Bold,
                        fontSize = 30.sp,
                        color = Color.White
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = noteAppGrayColor
                )
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navigateToAddANote()
                },
                shape = CircleShape,
                containerColor = noteAppGrayColor,
                contentColor = Color.White,
                elevation = FloatingActionButtonDefaults.elevation(
                    defaultElevation = 4.dp
                ),
                content = {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Save Note"
                    )
                }
            )

        }
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(it),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = modifier.height(25.dp))

            LazyColumn(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(4.dp)
            ) {
                items(
                   notes
                ) { note ->
                    NoteCard(
                        title = note.title,
                        details = note.details,
                        noteAppGrayColor = noteAppGrayColor,
                        onNoteClicked = {
                            onRemoveNote(
                                note
                            )
                        },
                        note = note
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun NoteScreenPreview() {
    NoteScreen(
        notes = emptyList(),
        onRemoveNote = {}
    )
}