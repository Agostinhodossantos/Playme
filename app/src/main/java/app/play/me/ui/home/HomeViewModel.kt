package app.play.me.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import app.play.me.models.TopMusic

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    private val _topMusic = MutableLiveData<List<TopMusic>>()
        val topMusic: LiveData<List<TopMusic>>
        get() = _topMusic

    init {
        _topMusic.value = getTopMusic()
    }

    private fun getTopMusic(): List<TopMusic> {
        var list = mutableListOf<TopMusic>()
        list.add(TopMusic(1, "Today's Top Hits", ""))
        list.add(TopMusic(1, "Today's Top Hits", ""))
        list.add(TopMusic(1, "Today's Top Hits", ""))
        list.add(TopMusic(1, "Today's Top Hits", ""))
        list.add(TopMusic(1, "Today's Top Hits", ""))
        list.add(TopMusic(1, "Today's Top Hits", ""))

        return list
    }
}