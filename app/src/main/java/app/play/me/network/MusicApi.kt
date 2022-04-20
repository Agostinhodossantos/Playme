package app.play.me.network

import retrofit2.http.GET

interface MusicApi {
    @GET("musics")
    suspend fun getMusic(): List<MusicObjectResponse>
}