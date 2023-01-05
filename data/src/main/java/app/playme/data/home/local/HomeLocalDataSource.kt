package app.playme.data.home.local

import app.playme.model.Music

interface HomeLocalDataSource {
    suspend fun getMusics(): List<Music>
}