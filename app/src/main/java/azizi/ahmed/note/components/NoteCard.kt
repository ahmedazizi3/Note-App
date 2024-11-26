package azizi.ahmed.note.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import azizi.ahmed.note.model.Note

@Composable
fun NoteCard(
    modifier: Modifier = Modifier,
    title: String,
    details: String,
    noteAppGrayColor: Color,
    onNoteClicked: (Note) -> Unit,
    note: Note
) {
    Card(
        shape = RoundedCornerShape(10.dp),
        modifier = modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = noteAppGrayColor
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        ),

    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = modifier.fillMaxHeight()
            ) {
                Text(
                    text = title,
                    color = Color.White,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Black
                )
                Text(
                    text = details,
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Normal
                )
            }
            Icon(
                imageVector = Icons.Default.Delete,
                contentDescription = null,
                tint = Color.White,
                modifier = modifier.clickable {
                    onNoteClicked(note)
                }
            )
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//private fun NoteCardPreview() {
//    NoteCard(
//        title = "Note 1",
//        details = "This is the first note",
//        noteAppGrayColor = Color(0xFF9199A0)
//    )
//
//}