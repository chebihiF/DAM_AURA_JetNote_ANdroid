package org.m2i.jetnote.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import org.m2i.jetnote.model.Note
import org.m2i.jetnote.util.DataConverter

@Database(entities = [Note::class], version = 1, exportSchema = false)
@TypeConverters(DataConverter::class)
abstract class NoteDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDatabaseDao // Data access object
}