package app.playme.com.vm

import app.playme.base.vm.MviViewModel
import app.playme.domain.usecases.OnBoardingCompletedUseCase
import app.playme.result.data
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
internal class MainViewModel @Inject constructor(
    private val onBoardingCompletedUseCase: OnBoardingCompletedUseCase
) : MviViewModel<ViewEvent, ViewResult, ViewState, ViewEffect>(ViewState()) {

    init {
        processEvent(ViewEvent.OnBoardingStatus)
    }

    override fun Flow<ViewEvent>.toResults(): Flow<ViewResult> {
        return merge(
            filterIsInstance<ViewEvent.OnBoardingStatus>().onBoardingToMainResult()
        )
    }

    private fun Flow<ViewEvent.OnBoardingStatus>.onBoardingToMainResult(): Flow<ViewResult> {
        return flatMapLatest {
            onBoardingCompletedUseCase(Unit).map { result ->
                delay(1000)
                ViewResult.OnBoardingShown(result.data ?: false)
            }
        }
    }

    override fun ViewResult.reduce(state: ViewState): ViewState {
        return when(this) {
            is ViewResult.OnBoardingShown -> state.copy(
                isOnBoardingShown = isShown
            )
        }
    }
}