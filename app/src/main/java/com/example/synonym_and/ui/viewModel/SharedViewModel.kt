package com.example.synonym_and.ui.viewModel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.synonym_and.data.database.SynonymEntity
import com.example.synonym_and.data.repository.SynonymRepository
import com.example.synonym_and.utils.Action
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor(
    private val repository: SynonymRepository,
    private val dateStoreRepository: SynonymRepository,
) : ViewModel() {
    var title by mutableStateOf("")
        private set
    var id by mutableStateOf(0)
        private set
    var action by mutableStateOf(Action.NO_ACTION)
        private set
    fun updateAction(newAction: Action) {
        action = newAction
    }
    fun handleDatabaseActions(action: Action) {
        Log.d("HandleDatabaseAction", "Triggered")
        when(action) {
            Action.ADD -> {
                addSynonym()
            }
            Action.UPDATE -> {
                updateSynonym()
            }
            Action.DELETE -> {
                deleteSynonym()
            }
            Action.DELETE_ALL -> {
                deleteAllSynonym()
            }
            Action.UNDO -> {
                addSynonym()
            }
            else -> {

            }
        }
    }
    private fun addSynonym(){
        viewModelScope.launch(Dispatchers.IO) {
            val synonym = SynonymEntity(
                title = title,
            )
            repository.addSynonym(synonymEntity = synonym)
        }
    }
    private fun updateSynonym(){
        viewModelScope.launch(Dispatchers.IO) {
            val synonym = SynonymEntity(
                id = id,
                title = title
            )
            repository.updateSynonym(synonymEntity = synonym)
        }
    }

    private fun deleteSynonym(){
        viewModelScope.launch (Dispatchers.IO){
            val synonym = SynonymEntity(
                id = id,
                title = title,
            )
            repository.deleteSynonym(synonymEntity = synonym)
        }
    }

    private fun deleteAllSynonym(){
        viewModelScope.launch (Dispatchers.IO){
            repository.deleteAllSynonym()
        }
    }

}