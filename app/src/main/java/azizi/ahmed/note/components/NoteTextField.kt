package azizi.ahmed.note.components

import androidx.compose.foundation.layout.width
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun NoteTextField(
    modifier: Modifier = Modifier,
    noteAppGrayColor: Color,
    text: String,
    onValueChange: (String) -> Unit,
    label: String
) {
    OutlinedTextField(
        value = text,
        onValueChange = onValueChange,
        label = {
            Text(
                text = label
            )
        },
        modifier = modifier
            .width(300.dp)
            .drawBehind {
                // Draw border only on the bottom side
                val borderWidth = 2.dp.toPx()
                val borderColor = noteAppGrayColor

                // Bottom border
                drawLine(
                    color = borderColor,
                    start = Offset(0f, size.height), // Start at the bottom-left corner
                    end = Offset(size.width, size.height), // End at the bottom-right corner
                    strokeWidth = borderWidth
                )
            },
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Color.Transparent,
            unfocusedBorderColor = Color.Transparent,
            unfocusedLabelColor = noteAppGrayColor,
            focusedLabelColor = noteAppGrayColor,
            unfocusedTextColor = Color.Black,
            focusedTextColor = Color.Black
        )

    )
}