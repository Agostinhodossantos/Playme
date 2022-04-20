package app.play.me.network

class MusicApi {
    @GET("musics")
    suspend fun getMusic(): List<MusicObjectResponse>
}