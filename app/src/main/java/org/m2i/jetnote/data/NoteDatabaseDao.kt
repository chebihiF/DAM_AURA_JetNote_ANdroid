package org.m2i.jetnote.data

import androidx.compose.runtime.MutableState
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import org.m2i.jetnote.model.Note

@Dao
interface NoteDatabaseDao {
    @Query("SELECT * from notes_tbl")
    fun getNotes(): Flow<List<Note>>
    @Query("SELECT * from notes_tbl where id =:id")
    suspend fun getNoteById(id: String) : Note
    @Query("DELETE from notes_tbl")
    suspend fun deleteAll()
    @Insert(onConflict= OnConflictStrategy.REPLACE)
    suspend fun insert(note: Note)
    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(note: Note)
    @Delete
    suspend fun deleteNote(note: Note)

}
