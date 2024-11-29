package azizi.ahmed.note.packages.components

import androidx.compose.foundation.layout.width
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
            .width(300.dp),
        colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent,
                unfocusedLabelColor = noteAppGrayColor,
                focusedLabelColor = noteAppGrayColor,
                unfocusedTextColor = noteAppGrayColor,
                focusedTextColor = noteAppGrayColor,
                cursorColor = noteAppGrayColor
        )
    )
}


