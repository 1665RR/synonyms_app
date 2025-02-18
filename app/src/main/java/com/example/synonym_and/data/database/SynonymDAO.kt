package com.example.synonym_and.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.synonym_and.data.model.SynonymItem
import kotlinx.coroutines.flow.Flow

@Dao
interface SynonymDAO {
    @Insert
    suspend fun insert(synonymItem: SynonymEntity)

    @Query("SELECT * FROM synonym_table")
    fun getAllRecords(): Flow<List<SynonymItem>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addSynonym(synonym: SynonymEntity)

    @Update
    suspend fun updateSynonym(synonym: SynonymEntity)

    @Delete
    suspend fun deleteSynonym(synonym: SynonymEntity)

    @Query("DELETE FROM synonym_table")
    suspend fun deleteAllSynonym()
}