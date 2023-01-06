package app.playme.com.presentation.navigation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import app.playme.compose.ui.blackBackground
import app.playme.model.Music

@Composable
fun BottomBar(
    navController: NavHostController,
    bottomBarState: MutableState<Boolean>
) {

    AnimatedVisibility(
        visible = bottomBarState.value,
        enter = slideInVertically(initialOffsetY = { it }),
        exit = slideOutVertically(targetOffsetY = { it })
    ) {

        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination

        CompositionLocalProvider(
            LocalLayoutDirection provides
                    if (LocalConfiguration.current.layoutDirection == LayoutDirection.Rtl.ordinal) {
                        LayoutDirection.Rtl
                    } else {
                        LayoutDirection.Ltr
                    }
        ) {
            var music = Music("1", "https://i.ibb.co/jZYyyBV/4.jpg", "UNCENSORED Interview ", "Cover","","","Agostinho", "04:00 min")

            Column {
                TopPlayer(music = music){}
                BottomNavigation(
                    modifier = Modifier.navigationBarsPadding().height(70.dp).blackBackground(),
                    backgroundColor = Color.Transparent,
                ) {
                    screens.forEach { screen ->
                        AddItem(
                            screen = screen,
                            currentDestination = currentDestination,
                            navController = navController
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: NavigationModel,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    BottomNavigationItem(
        label = {
            Text(
                text = stringResource(id = screen.title),
                style = MaterialTheme.typography.caption,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },
        icon = {
            Icon(imageVector = screen.icon, contentDescription = null)
        },
        selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
        unselectedContentColor = Color.White,
        selectedContentColor = Color(0xFF299E46),
        onClick = {
            if (currentDestination?.hierarchy?.any { it.route == screen.route } == false) {
                navController.navigate(screen.route) {
                    popUpTo(navController.graph.findStartDestination().id)

                    launchSingleTop = true
                }
            }
        }
        )
}

val screens = listOf(
    NavigationModel.Songs,
    NavigationModel.Albums,
    NavigationModel.Artists,
    NavigationModel.PlayList,
)

