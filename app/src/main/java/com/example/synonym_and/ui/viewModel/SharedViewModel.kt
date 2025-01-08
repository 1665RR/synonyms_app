package com.example.synonym_and.ui.viewModel

import androidx.lifecycle.ViewModel
import com.example.synonym_and.data.repository.SynonymRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor(
    private val repository: SynonymRepository,
    private val dateStoreRepository: SynonymRepository,
) : ViewModel() {
}