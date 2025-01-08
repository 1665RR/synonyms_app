package com.example.synonym_and.data.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [SynonymEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun synonymDao() : SynonymDAO
}