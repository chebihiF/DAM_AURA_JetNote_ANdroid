package org.m2i.jetnote.screen

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import org.m2i.jetnote.model.Note
import org.m2i.jetnote.repository.NoteRepository
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(private val repository: NoteRepository) : ViewModel() {

    private val _notesList = MutableStateFlow<List<Note>>(emptyList())
    val notesList = _notesList.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO){
            repository.getAllNotes().distinctUntilChanged()
                .collect{listOfNotes ->
                    if(listOfNotes.isNullOrEmpty()){
                        Log.d("TAG","Empty List")
                    }else{
                        _notesList.value = listOfNotes
                    }
                }
        }
    }
    suspend fun addNote(note: Note) = viewModelScope.launch { repository.addNote(note = note) }
    suspend fun updateNote(note: Note) = viewModelScope.launch { repository.deleteNote(note = note) }
    suspend fun removeNote(note: Note) = viewModelScope.launch { repository.deleteNote(note = note) }






    //private var noteList = mutableStateListOf<Note>()
    /*fun addNote(note: Note){
        noteList.add(note)
    }
    fun removeNote(note: Note){
        noteList.remove(note)
    }
    fun getAllNotes(): List<Note>{
        return noteList
    }*/
}