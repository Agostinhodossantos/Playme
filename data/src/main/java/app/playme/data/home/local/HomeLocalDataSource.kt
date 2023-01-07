package app.playme.data.home.local

import app.playme.model.Song

interface HomeLocalDataSource {
    suspend fun getSongs(): List<Song>
}