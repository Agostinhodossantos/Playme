package app.playme.data.pref

import androidx.datastore.preferences.core.booleanPreferencesKey

object PreferencesKeys {
    val onBoardingCompletedKey = booleanPreferencesKey("show_completed")
}