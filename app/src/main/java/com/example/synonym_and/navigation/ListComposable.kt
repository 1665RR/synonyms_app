package com.example.synonym_and.navigation

import Constants.SYNONYM_ARGUMENT_KEY
import Constants.SYNONYM_SCREEN
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.synonym_and.ui.viewModel.SharedViewModel

fun NavGraphBuilder.listComposable (
    navigateToSynonymScreen: (synonymID: Int) -> Unit,
    sharedViewModel: SharedViewModel
) {
    composable(
        route = SYNONYM_SCREEN,
        arguments = listOf(navArgument(SYNONYM_ARGUMENT_KEY) {
            type = NavType.StringType
        })

    ) {  }
}