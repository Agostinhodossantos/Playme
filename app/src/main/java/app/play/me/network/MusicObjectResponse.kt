package app.play.me.network

import com.squareup.moshi.Json

data class MusicObjectResponse (
    val id: Int,
    val title: String,
    val url: String,
    val cover: String
)