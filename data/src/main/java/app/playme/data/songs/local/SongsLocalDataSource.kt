package app.playme.data.songs.local

import app.playme.model.Music

interface SongsLocalDataSource {
    suspend fun getAllSongs(music: Music)
    suspend fun getSong(music: Music)
}