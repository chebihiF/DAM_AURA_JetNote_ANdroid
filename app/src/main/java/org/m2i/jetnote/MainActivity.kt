package org.m2i.jetnote

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import org.m2i.jetnote.model.Note
import org.m2i.jetnote.screen.NoteScreen
import org.m2i.jetnote.ui.theme.JetNoteTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetNoteTheme {
                val notes = remember {
                    mutableStateListOf<Note>()
                }
                // A surface container using the 'background' color from the theme
                NoteScreen(
                    notes = notes,
                    onAddNote = {notes.add(it)},
                    onRemoveNote = {notes.remove(it)})
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetNoteTheme {

    }
}