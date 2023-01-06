package app.playme.model

import java.time.Duration

data class Music(
    var id: String,
    val uri: String,
    val title: String,
    val cover: String,
    val subtitle: String,
    val summary: String? = null,
    val author: String,
    val duration: String,
    val isPlaying: Boolean = false
)