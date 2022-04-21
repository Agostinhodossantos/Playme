package app.play.me.di

import app.play.me.database.CacheMapper
import app.play.me.database.MusicDao
import app.play.me.network.MusicApi
import app.play.me.network.MusicMapper
import app.play.me.repository.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideRepository(
        musicDao: MusicDao,
        musicApi: MusicApi,
        cacheMapper: CacheMapper,
        musicMapper: MusicMapper
    ): MainRepository {
        return MainRepository(musicDao, musicApi, cacheMapper, musicMapper)
    }
}