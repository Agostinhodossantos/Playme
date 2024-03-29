package app.playme.com.presentation

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import app.playme.com.presentation.navigation.AppNavigation
import app.playme.com.presentation.navigation.BottomBar
import app.playme.com.presentation.navigation.Navigate
import app.playme.com.vm.MainViewModel
import app.playme.com.vm.ViewEvent
import app.playme.compose.theme.BottomSheetShape
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.google.accompanist.navigation.material.ModalBottomSheetLayout
import com.google.accompanist.navigation.material.rememberBottomSheetNavigator

@Composable
internal fun MainScreen(mainViewModel: MainViewModel, onLauncherFinished : () -> Unit) {
    val bottomSheetNavigator = rememberBottomSheetNavigator()
    val navController = rememberAnimatedNavController(bottomSheetNavigator)
    val bottomBarState = rememberSaveable { (mutableStateOf(false)) }

    val viewState by mainViewModel.states.collectAsState()
    if (viewState.isOnBoardingShown == null) {
        mainViewModel.processEvent(ViewEvent.OnBoardingStatus)
    } else {
        val screen = if (viewState.isOnBoardingShown == true) {
            Navigate.Screen.Main.route
        } else {
            Navigate.Screen.OnBoardingWelcome.route
        }

        ModalBottomSheetLayout(
            bottomSheetNavigator = bottomSheetNavigator,
            sheetShape = BottomSheetShape,
            sheetBackgroundColor = Color.Transparent
        ) {
            Scaffold(
                backgroundColor = MaterialTheme.colors.surface,
                bottomBar = {
                    BottomBar(navController, bottomBarState)
                }
            ) {
                BoxWithConstraints(
                    modifier = Modifier.fillMaxSize()

                ) {
                    AppNavigation(
                        navController = navController,
                        startDestination = screen,
                        width = constraints.maxWidth / 2,
                        bottomBarPadding = it,
                        bottomBarState = bottomBarState
                    )
                }
            }
        }
        onLauncherFinished()
    }
}
