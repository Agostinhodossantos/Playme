package app.play.me.model

data class TopMusic(
    val id: Long,
    val title: String,
    var img: String,
    var isCurrent: Boolean = false
)