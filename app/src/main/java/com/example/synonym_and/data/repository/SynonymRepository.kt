package com.example.synonym_and.data.repository

import com.example.synonym_and.data.database.SynonymDAO
import com.example.synonym_and.data.database.SynonymEntity
import com.example.synonym_and.data.model.SynonymItem
import kotlinx.coroutines.flow.Flow

class SynonymRepository(private val synonymDAO: SynonymDAO) {
    suspend fun insertSynonym(synonym: SynonymItem) {
        synonymDAO.insert(synonym)
    }

    suspend fun getAllSynonyms() : Flow<List<SynonymItem>> {
        return synonymDAO.getAllRecords()
    }
}