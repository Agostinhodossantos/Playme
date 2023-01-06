package app.playme.com.presentation.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.ui.graphics.vector.ImageVector
import app.playme.com.R

sealed class NavigationModel(
    val route: String,
    @StringRes val title: Int,
    val icon: ImageVector
) {

    object Songs : NavigationModel(
        route = Navigate.Screen.Main.route,
        title = R.string.discover_title,
        icon = Icons.Outlined.Home
    )

    object Albums : NavigationModel(
        route = Navigate.Screen.Albums.route,
        title = R.string.albums,
        icon = Icons.Outlined.LibraryMusic
    )

    object Artists : NavigationModel(
        route = Navigate.Screen.Artists.route,
        title = R.string.artists,
        icon = Icons.Outlined.ArtTrack
    )

    object PlayList : NavigationModel(
        route = Navigate.Screen.Playlist.route,
        title = R.string.playlist,
        icon = Icons.Outlined.PlaylistPlay
    )

    object Settings : NavigationModel(
        route = Navigate.Screen.Settings.route,
        title = R.string.search_title,
        icon = Icons.Outlined.Settings
    )

}
