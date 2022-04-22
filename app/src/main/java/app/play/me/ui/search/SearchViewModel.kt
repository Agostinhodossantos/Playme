package app.play.me.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import app.play.me.model.Genre
import app.play.me.utils.DataProvider

class SearchViewModel : ViewModel() {

    private val _genres = MutableLiveData<List<Genre>>().apply {
        value = DataProvider.getGenreList()
    }


    val genreList: LiveData<List<Genre>> = _genres
}