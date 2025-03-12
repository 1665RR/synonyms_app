package com.example.synonym_and.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface SynonymDAO {
    // Insert a new synonym item
    @Insert
    suspend fun insert(synonymItem: SynonymEntity)

    // Get all records from the synonym table
    @Query("SELECT * FROM synonym_table")
    fun getAllRecords(): Flow<List<SynonymEntity>>  // Return SynonymEntity, as it's the room entity

    // Add a synonym if it doesn't already exist (ignore if conflict)
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addSynonym(synonym: SynonymEntity)

    // Update an existing synonym item
    @Update
    suspend fun updateSynonym(synonym: SynonymEntity)

    // Delete a specific synonym item
    @Delete
    suspend fun deleteSynonym(synonym: SynonymEntity)

    // Delete all synonym items
    @Query("DELETE FROM synonym_table")
    suspend fun deleteAllSynonym()
}
