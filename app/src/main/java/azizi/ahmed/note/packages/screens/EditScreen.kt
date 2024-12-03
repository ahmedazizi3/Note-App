package azizi.ahmed.note.packages.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import azizi.ahmed.note.packages.components.NoteTextField
import azizi.ahmed.note.packages.model.Note

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditScreen(
    modifier: Modifier = Modifier,
    note: Note?,
    onEditNote: (Note) -> Unit = {},
    navigateBack: () -> Unit
) {
    var editedTitle by remember { mutableStateOf(note?.title ?: "") }
    var editedDetails by remember { mutableStateOf(note?.details ?: "") }
    val noteAppGrayColor: Color = Color(0xFF005784)

    Scaffold(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = if (note == null) "Add Note" else "Edit Note", // Change the title based on whether it's new or editing
                        fontWeight = FontWeight.Bold,
                        fontSize = 30.sp,
                        color = Color.White
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = noteAppGrayColor
                ),
                navigationIcon = {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Go Back",
                        modifier = modifier
                            .size(30.dp)
                            .clickable {
                                navigateBack()
                            },
                        tint = Color.White
                    )
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    if (editedTitle.isNotEmpty() && editedDetails.isNotEmpty()) {
                        // Check if note is being updated or added
                        val updatedNote = note?.copy(
                            title = editedTitle,
                            details = editedDetails
                        ) ?: Note(
                            title = editedTitle,
                            details = editedDetails
                        )

                        onEditNote(updatedNote)  // Pass the updated note
                        navigateBack()
                    }
                },
                shape = CircleShape,
                containerColor = noteAppGrayColor,
                contentColor = Color.White,
                elevation = FloatingActionButtonDefaults.elevation(
                    defaultElevation = 4.dp
                ),
                content = {
                    Icon(
                        imageVector = Icons.Default.Check,
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
                .padding(it)
                .padding(8.dp)
        ) {
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .height(60.dp)
            ) {
                NoteTextField(
                    modifier = modifier.fillMaxSize(),
                    noteAppGrayColor = noteAppGrayColor,
                    text = editedTitle,
                    onValueChange = {
                        editedTitle = it
                    },
                    label = "Title",
                    isSingleLine = true
                )
            }

            HorizontalDivider()

            Spacer(modifier = modifier.height(15.dp))

            NoteTextField(
                modifier = modifier.fillMaxSize(),
                noteAppGrayColor = noteAppGrayColor,
                text = editedDetails,
                onValueChange = {
                    editedDetails = it
                },
                label = "Details",
                isSingleLine = false
            )
        }
    }
}
