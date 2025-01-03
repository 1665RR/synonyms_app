package com.example.synonym_and.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "synonym_table")
data class SynonymEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val text: String,
)
