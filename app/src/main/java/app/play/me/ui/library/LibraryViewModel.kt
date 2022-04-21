package app.play.me.ui.library

import androidx.lifecycle.*
import app.play.me.model.Music
import app.play.me.repository.MainRepository
import app.play.me.utils.DataState
import dagger.assisted.Assisted
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LibraryViewModel @Inject constructor(
    private val mainRepository: MainRepository
) : ViewModel() {
    private val _dataState: MutableLiveData<DataState<List<Music>>> = MutableLiveData()

    val dataState: LiveData<DataState<List<Music>>>
       get() = _dataState

    fun setStateEvent(mainStateEvent: MainStateEvent) {
        viewModelScope.launch {
            when(mainStateEvent) {
                is MainStateEvent.GetMusicsEvents -> {
                    mainRepository.getMusics()
                        .onEach {  dataState ->
                            _dataState.value = dataState
                        }
                        .launchIn(viewModelScope)
                }

                is MainStateEvent.None -> {
                    // No action
                }
            }
        }
    }


}

sealed class MainStateEvent {
    object GetMusicsEvents : MainStateEvent()
    object None : MainStateEvent()
}