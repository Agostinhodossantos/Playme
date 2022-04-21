package app.play.me.repository

import app.play.me.database.CacheMapper
import app.play.me.database.MusicDao
import app.play.me.model.Music
import app.play.me.network.MusicApi
import app.play.me.network.MusicMapper
import app.play.me.utils.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import timber.log.Timber

class MainRepository
constructor(
    private val musicDao: MusicDao,
    private val musicApi: MusicApi,
    private val cacheMapper: CacheMapper,
    private val musicMapper: MusicMapper
) {
    suspend fun getMusics(): Flow<DataState<List<Music>>> = flow {
        emit(DataState.Loading)
        try {
            val networkMusic = musicApi.getMusic()
            val musics = musicMapper.mapFromEntityList(networkMusic)
            Timber.d("Musics$musics")
            for (music in musics) {
                musicDao.insert(cacheMapper.mapToEntity(music))
            }
            val cachedMusics = musicDao.getMusics()
            emit(DataState.Success(cacheMapper.mapFromEntityList(cachedMusics)))
        } catch (e: Exception) {
            emit(DataState.Error(e))
        }
    }
}