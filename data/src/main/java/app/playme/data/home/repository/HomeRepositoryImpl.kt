package app.playme.data.home.repository

import app.playme.data.home.local.HomeLocalDataSource
import app.playme.model.Song
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val homeLocalDataSource: HomeLocalDataSource
): HomeRepository {
    override suspend fun getMusics(): List<Song> {
        //        val songs = savedSongs.ifEmpty {
//
//        }
        return homeLocalDataSource.getSongs()
    }

    override suspend fun getAlbums(): List<Song> {
        return homeLocalDataSource.getSongs()
    }
}