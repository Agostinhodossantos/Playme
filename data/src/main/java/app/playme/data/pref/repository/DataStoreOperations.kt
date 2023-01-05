package app.playme.data.pref.repository

import androidx.datastore.preferences.core.Preferences
import kotlinx.coroutines.flow.Flow
import app.playme.result.Result

interface DataStoreOperations {
    suspend fun save(key: Preferences.Key<Boolean>, value: Boolean)
    fun read(key: Preferences.Key<Boolean>): Flow<Result<Boolean>>
}