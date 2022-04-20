package app.play.me.network

data class MusicObjectResponse (
    @field:Json(name: "pk") val id: Int,
    val title: String,
    val url: String,
    val cover: String
)