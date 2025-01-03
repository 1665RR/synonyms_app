package com.example.synonym_and.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.synonym_and.data.model.SynonymItem

@Database(entities = [SynonymItem::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun synonymDao() : SynonymDAO
}