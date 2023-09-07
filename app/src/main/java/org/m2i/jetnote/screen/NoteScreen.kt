package org.m2i.jetnote.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import org.m2i.jetnote.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteScreen(){
    Scaffold(topBar = {
        CenterAlignedTopAppBar(
            title = { Text(text = stringResource(id = R.string.app_name)) })
    })

    { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {

        }
    }
}

@Preview(showBackground = true)
@Composable
fun NoteScreenPreview() {
    NoteScreen()
}