package app.playme.data.songs.local

import app.playme.model.Song

interface SongsLocalDataSource {
    suspend fun getAllSongs(song: Song)
    suspend fun getSong(song: Song)
}