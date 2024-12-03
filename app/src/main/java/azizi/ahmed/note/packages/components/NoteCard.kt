package azizi.ahmed.note.packages.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import azizi.ahmed.note.packages.model.Note

@Composable
fun NoteCard(
    modifier: Modifier = Modifier,
    title: String,
    details: String,
    noteAppGrayColor: Color,
    onDeleteClicked: (Note) -> Unit,
    onEditClicked: (Note) -> Unit = {},
    note: Note
) {
    Card(
        shape = RoundedCornerShape(10.dp),
        modifier = modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(8.dp)
            .clickable {
                onEditClicked(note)
            },
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
                modifier = modifier
                    .fillMaxHeight()
                    .width(320.dp)
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
                    onDeleteClicked(note)
                }
            )
        }
    }
}



