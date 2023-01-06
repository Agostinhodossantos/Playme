package app.playme.model

import java.time.Duration

data class Music(
    var id: String,
    val uri: String,
    val title: String,
    val cover: String,
    val subtitle: String? = null,
    val summary: String? = null,
    val author: String? = null,
    val duration: Duration? = null,
    val isPlaying: Boolean = false
)