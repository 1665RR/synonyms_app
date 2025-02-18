package com.example.synonym_and.data.repository

import com.example.synonym_and.data.database.SynonymDAO
import com.example.synonym_and.data.database.SynonymEntity
import com.example.synonym_and.data.model.SynonymItem
import kotlinx.coroutines.flow.Flow

class SynonymRepository(private val synonymDAO: SynonymDAO) {
    suspend fun insertSynonym(synonym: SynonymEntity) {
        synonymDAO.insert(synonym)
    }

    suspend fun getAllSynonyms() : Flow<List<SynonymItem>> {
        return synonymDAO.getAllRecords()
    }

    suspend fun addSynonym(synonymEntity: SynonymEntity) {
        return synonymDAO.addSynonym(synonym = synonymEntity)
    }

    suspend fun updateSynonym(synonymEntity: SynonymEntity) {
        return synonymDAO.updateSynonym(synonym = synonymEntity)
    }

    suspend fun deleteSynonym(synonymEntity: SynonymEntity) {
        return synonymDAO.deleteSynonym(synonym = synonymEntity)
    }

    suspend fun deleteAllSynonym() {
        return synonymDAO.deleteAllSynonym()
    }
}