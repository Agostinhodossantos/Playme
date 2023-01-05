package app.playme.data.home.repository

import app.playme.model.Music

interface HomeRepository {
    suspend fun getMusics(): List<Music>
    suspend fun getAlbums(): List<Music>
}