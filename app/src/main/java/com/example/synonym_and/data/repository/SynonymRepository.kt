package com.example.synonym_and.data.repository

import com.example.synonym_and.data.database.SynonymDAO
import com.example.synonym_and.data.database.SynonymEntity
import com.example.synonym_and.data.model.SynonymItem
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


@ViewModelScoped
class SynonymRepository @Inject constructor(private val synonymDAO: SynonymDAO) {

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