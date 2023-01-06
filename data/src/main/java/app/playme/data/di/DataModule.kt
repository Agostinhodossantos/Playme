package app.playme.data.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStoreFile
import app.playme.data.home.local.HomeLocalDataSource
import app.playme.data.home.local.HomeLocalDataSourceImpl
import app.playme.data.home.repository.HomeRepository
import app.playme.data.home.repository.HomeRepositoryImpl
import app.playme.data.pref.repository.DataStoreOperations
import app.playme.data.pref.repository.DataStoreRepository
import app.playme.inject.IoDispatcher
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import javax.inject.Singleton

private const val DATA_SOURCE_NAME = "PlaymeDataStore"

@InstallIn(SingletonComponent::class)
@Module
class DataModule {

    @Singleton
    @Provides
    fun provideDataStore(
        @ApplicationContext context: Context,
        @IoDispatcher ioDispatcher: CoroutineDispatcher
    ): DataStore<Preferences> {
        return PreferenceDataStoreFactory.create(
            corruptionHandler = ReplaceFileCorruptionHandler(
                produceNewData = { emptyPreferences() }
            ),
            scope = CoroutineScope(ioDispatcher),
            produceFile = { context.preferencesDataStoreFile(DATA_SOURCE_NAME) }
        )
    }


    @Provides
    fun provideHomeRepository(
        homeLocalDataSource: HomeLocalDataSource
    ): HomeRepository =
        HomeRepositoryImpl(homeLocalDataSource)

    @Provides
    fun provideHomeLocalDataSource(

    ): HomeLocalDataSource = HomeLocalDataSourceImpl()


    @Singleton
    @Provides
    fun provideDataStoreRepository(dataStore: DataStore<Preferences>): DataStoreOperations =
        DataStoreRepository(dataStore)

}
