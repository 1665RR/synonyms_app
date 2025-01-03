package com.example.synonym_and.data.database

import androidx.room.Insert
import androidx.room.Query
import com.example.synonym_and.data.model.SynonymItem
import kotlinx.coroutines.flow.Flow

interface SynonymDAO {
    @Insert
    suspend fun insert(synonymItem: SynonymItem)

    @Query("SELECT * FROM synonym_table")
    fun getAllRecords(): Flow<List<SynonymItem>>
}