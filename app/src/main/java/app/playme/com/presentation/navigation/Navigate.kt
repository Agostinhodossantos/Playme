package app.playme.com.presentation.navigation

sealed class Navigate(val route: String){

    sealed class BottomSheet {
        object Player : Navigate("player")
    }

    sealed class Screen {

        object Main : Navigate("main_screen")

        object Songs : Navigate("songs_screen")

        object Albums : Navigate("albums_screen")

        object Artists : Navigate("artists_screen")

        object Playlist : Navigate("playlist_screen")

        object Settings : Navigate("settings_screen")

        object OnBoardingWelcome : Navigate("onboarding_welcome_screen")

        object Details : Navigate("details")

        object Notifications : Navigate("notifications_screen")
    }
}
