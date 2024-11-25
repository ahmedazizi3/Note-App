package azizi.ahmed.note.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import azizi.ahmed.note.components.AddingButton
import azizi.ahmed.note.components.NoteCard
import azizi.ahmed.note.components.NoteTextField
import azizi.ahmed.note.data.NoteData
import azizi.ahmed.note.model.Note

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteScreen(
    modifier: Modifier = Modifier,
    notes: List<Note>,
    onAddNote: (Note) -> Unit,
    onRemoveNote: (Note) -> Unit
) {
    var title by remember {
        mutableStateOf("")
    }
    var details by remember {
        mutableStateOf("")
    }
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
        }
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(it),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = modifier.height(30.dp))

            NoteTextField(
                noteAppGrayColor = noteAppGrayColor,
                text = title,
                onValueChange = {
                    title = it
                },
                label = "Title"
            )

            Spacer(modifier = modifier.height(20.dp))

            NoteTextField(
                noteAppGrayColor = noteAppGrayColor,
                text = details,
                onValueChange = {
                    details = it
                },
                label = "Details"
            )

            Spacer(modifier = modifier.height(20.dp))

            AddingButton(
                noteAppGrayColor = noteAppGrayColor,
                onClick = {
                    if (title.isNotEmpty() && details.isNotEmpty()) {
                        // Add to the list
                        onAddNote(
                            Note(
                                title = title,
                                details = details
                            )
                        )
                        title = ""
                        details = ""
                    }
                },
                text = "Add"
            )

            Spacer(modifier = modifier.height(20.dp))

            HorizontalDivider(color = noteAppGrayColor)

            Spacer(modifier = modifier.height(10.dp))

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
                        noteAppGrayColor = noteAppGrayColor
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
        notes = NoteData().loadNotes(),
        onAddNote = {},
        onRemoveNote = {}
    )
}