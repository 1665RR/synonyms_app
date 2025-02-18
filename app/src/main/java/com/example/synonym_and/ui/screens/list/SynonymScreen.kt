package com.example.synonym_and.ui.screens.list

import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import com.example.synonym_and.ui.viewModel.SharedViewModel
import com.example.synonym_and.utils.Action
import androidx.compose.runtime.rememberCoroutineScope

@Composable

fun SynonymScreen(
    action: Action,
    navigateToSynonymScreen: (synonymId: Int) -> Unit,
    sharedViewModel: SharedViewModel
) {
    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(key1 = action) {
        sharedViewModel.handleDatabaseActions(action = action)
    }
    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) },
        topBar = TODO(),
        floatingActionButton = TODO(),
        content = TODO(),
    )


}