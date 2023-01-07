package app.playme.data.songs.repository

import androidx.paging.PagingData
import app.playme.model.Song
import kotlinx.coroutines.flow.Flow

interface SongsRepository {
    fun searchSongs(
        query: String?,
    ): Flow<PagingData<Song>>

    suspend fun getAllMusics(): Flow<PagingData<Song>>

    suspend fun getMusic(id: String): Flow<PagingData<Song>>
}