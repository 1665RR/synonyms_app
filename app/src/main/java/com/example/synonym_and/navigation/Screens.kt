package com.example.synonym_and.navigation

import androidx.navigation.NavHostController

class Screens(navHostController: NavHostController) {
    val list: (Int) -> Unit = {
        synonymID -> navHostController.navigate(route = "synonym/$synonymID")
    }

}