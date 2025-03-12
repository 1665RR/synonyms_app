package com.example.synonym_and.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.synonym_and.data.database.SynonymDAO
import com.example.synonym_and.data.database.SynonymEntity

@Database(entities = [SynonymEntity::class], version = 1, exportSchema = false)
abstract class SynonymDatabase : RoomDatabase() {
    abstract  fun synonymDAO() : SynonymDAO
}