package app.play.me.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import app.play.me.model.TopMusic

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
        list.add(TopMusic(1, "Today's Top Hits", "", true))
        list.add(TopMusic(1, "This is Justin bieber", "", ))
        list.add(TopMusic(1, "All Out 2010s", ""))
        list.add(TopMusic(1, "Mega Hit Mix", ""))
        list.add(TopMusic(1, "Make me better", ""))
        list.add(TopMusic(1, "Impact Theory with Tom", ""))

        return list
    }
}