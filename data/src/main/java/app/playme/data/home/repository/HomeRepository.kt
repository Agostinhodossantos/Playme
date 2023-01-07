package app.playme.data.home.repository

import app.playme.model.Song

interface HomeRepository {
    suspend fun getMusics(): List<Song>
    suspend fun getAlbums(): List<Song>
}