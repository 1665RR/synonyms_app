package com.example.synonym_and.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.synonym_and.data.model.SynonymItem
import kotlinx.coroutines.flow.Flow

@Dao
interface SynonymDAO {
    @Insert
    suspend fun insert(synonymItem: SynonymEntity)

    @Query("SELECT * FROM synonym_table")
    fun getAllRecords(): Flow<List<SynonymItem>>
}