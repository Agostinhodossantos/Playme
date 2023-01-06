package app.playme.com.presentation.navigation

import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import app.playme.onboarding.OnBoardingScreen
import app.playme.songs.ui.Songs
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun AppNavigation(
    navController: NavHostController,
    startDestination: String,
    width: Int,
    bottomBarPadding: PaddingValues,
    bottomBarState: MutableState<Boolean>
) {
    AnimatedNavHost(
        navController = navController,
        startDestination = startDestination,
        builder = {
            onBoardingScreen(navController, bottomBarState)
            mainScreenScreen(navController, bottomBarPadding, bottomBarState)
        }
    )
}

fun NavGraphBuilder.onBoardingScreen(
    navController: NavController,
    bottomBarState: MutableState<Boolean>
) {
    composable(
        route = Navigate.Screen.OnBoardingWelcome.route
    ) {
        bottomBarState.value = false
        OnBoardingScreen {
            navController.navigate(Navigate.Screen.Main.route)
        }
    }
}

fun NavGraphBuilder.mainScreenScreen(
    navController: NavController,
    bottomBarPadding: PaddingValues,
    bottomBarState: MutableState<Boolean>
) {
    composable(
        route = Navigate.Screen.Main.route
    ) {
        bottomBarState.value = true
        val systemUiController = rememberSystemUiController()
        SideEffect {
            systemUiController.setStatusBarColor(
                color = Color(0xFF2B292B),
                darkIcons = false
            )
            systemUiController.setNavigationBarColor(
                color = Color(0xFF2B292B),
                darkIcons = false
            )
        }
        val activity = (LocalContext.current as? Activity)

        BackHandler(true) {
            activity?.finish()
        }
        Songs(
            bottomBarPadding = bottomBarPadding,
            onDetails =  {
                 navController.navigate(Navigate.Screen.Details.route+"/$it")
            },
            onSongs = {
                 navController.navigate(Navigate.BottomSheet.Player.route)
            },
            onSongsSearch = {
                navController.navigate(Navigate.Screen.Artists.route + "/$it")
            }
        )
    }
}