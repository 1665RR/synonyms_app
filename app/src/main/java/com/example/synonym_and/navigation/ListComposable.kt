package com.example.synonym_and.navigation

import Constants.SYNONYM_ARGUMENT_KEY
import Constants.SYNONYM_SCREEN
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.synonym_and.ui.screens.list.SynonymScreen
import com.example.synonym_and.ui.viewModel.SharedViewModel
import com.example.synonym_and.utils.Action
import com.example.synonym_and.utils.toAction

fun NavGraphBuilder.listComposable (
    navigateToSynonymScreen: (synonymID: Int) -> Unit,
    sharedViewModel: SharedViewModel
) {
    composable(
        route = SYNONYM_SCREEN,
        arguments = listOf(navArgument(SYNONYM_ARGUMENT_KEY) {
            type = NavType.StringType
        })

    ) {
        navBackStackEntry ->
        val action = navBackStackEntry.arguments?.getString(SYNONYM_ARGUMENT_KEY).toAction()

        var newAction by rememberSaveable { mutableStateOf(Action.NO_ACTION) }

        LaunchedEffect(key1 = newAction) {
            if(action != newAction) {
                newAction = action
                sharedViewModel.updateAction(newAction = action)
            }
        }

        val databaseAction = sharedViewModel.action

        SynonymScreen(
            action = databaseAction,
            navigateToSynonymScreen = navigateToSynonymScreen,
            sharedViewModel = sharedViewModel
        )
    }
}