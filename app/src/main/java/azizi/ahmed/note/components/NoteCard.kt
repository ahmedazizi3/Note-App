package azizi.ahmed.note.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun NoteCard(
    modifier: Modifier = Modifier,
    title: String,
    details: String,
    noteAppGrayColor: Color
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
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalAlignment = Alignment.Start
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
    }
}

@Preview(showBackground = true)
@Composable
private fun NoteCardPreview() {
    NoteCard(
        title = "Note 1",
        details = "This is the first note",
        noteAppGrayColor = Color(0xFF9199A0)
    )

}