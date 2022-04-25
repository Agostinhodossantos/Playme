package app.play.me.common

import app.play.me.model.Music

object MockUtil {

    fun mockMusic() = Music(
        id = 1,
        title = "Justin",
        url = "url",
        cover = "cover"
    )

    fun mockMusicList() = listOf(mockMusic())
}