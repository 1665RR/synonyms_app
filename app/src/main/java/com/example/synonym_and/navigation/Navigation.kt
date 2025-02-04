import Constants.SYNONYM_SCREEN
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import com.example.synonym_and.navigation.Screens
import com.example.synonym_and.ui.viewModel.SharedViewModel
import com.example.synonym_and.navigation.listComposable

@Composable
fun SetupNavigation(
    navHostController: NavHostController,
    sharedViewModel: SharedViewModel
) {
    val screen = remember(navHostController) {
        Screens(navHostController = navHostController)
    }
    NavHost(
        navController = navHostController,
        startDestination= SYNONYM_SCREEN
    ) {
        listComposable(
            navigateToSynonymScreen = screen.list,
            sharedViewModel = sharedViewModel,
        )
    }
}