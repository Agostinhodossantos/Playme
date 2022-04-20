package app.play.me.network

import com.squareup.moshi.Json

data class MusicObjectResponse (
    @field:Json(name = "count") val id: Int,
    val title: String,
    val url: String,
    val cover: String
)