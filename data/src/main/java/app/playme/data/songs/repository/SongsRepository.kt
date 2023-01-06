package app.playme.data.songs.repository

import androidx.paging.PagingData
import app.playme.model.Music
import kotlinx.coroutines.flow.Flow

interface SongsRepository {
    fun searchSongs(
        query: String?,
    ): Flow<PagingData<Music>>

    suspend fun getAllMusics(): Flow<PagingData<Music>>

    suspend fun getMusic(id: String): Flow<PagingData<Music>>
}