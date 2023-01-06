package app.playme.data.home.repository

import app.playme.data.home.local.HomeLocalDataSource
import app.playme.model.Music
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val homeLocalDataSource: HomeLocalDataSource
): HomeRepository {
    override suspend fun getMusics(): List<Music> {
        //        val songs = savedSongs.ifEmpty {
//
//        }
        return homeLocalDataSource.getMusics()
    }

    override suspend fun getAlbums(): List<Music> {
        return homeLocalDataSource.getMusics()
    }
}