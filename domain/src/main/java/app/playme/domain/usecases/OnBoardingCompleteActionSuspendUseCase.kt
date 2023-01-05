package app.playme.domain.usecases

import app.playme.data.pref.PreferencesKeys
import app.playme.data.pref.repository.DataStoreOperations
import app.playme.domain.SuspendUseCase
import app.playme.inject.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class OnBoardingCompleteActionSuspendUseCase @Inject constructor(
    private val dataStoreRepository: DataStoreOperations,
    @IoDispatcher dispatcher: CoroutineDispatcher
) : SuspendUseCase<Boolean, Unit>(dispatcher) {
    override suspend fun execute(parameters: Boolean) =
        dataStoreRepository.save(PreferencesKeys.onBoardingCompletedKey, true)
}
