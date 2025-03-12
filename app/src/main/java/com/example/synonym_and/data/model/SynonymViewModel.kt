package com.example.synonym_and.data.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.synonym_and.data.repository.SynonymRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SynonymViewModel(private val synonymRepository: SynonymRepository): ViewModel() {

    private val _synonyms = MutableStateFlow<List<SynonymItem>>(emptyList())
    val synonym: StateFlow<List<SynonymItem>> = _synonyms

}