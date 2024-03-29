package app.playme.domain.usecases

import app.playme.data.pref.PreferencesKeys
import app.playme.data.pref.repository.DataStoreOperations
import app.playme.domain.FlowUseCase
import app.playme.inject.IoDispatcher
import app.playme.result.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class OnBoardingCompletedUseCase @Inject constructor(
    private val dataStoreRepository: DataStoreOperations,
    @IoDispatcher dispatcher: CoroutineDispatcher
) : FlowUseCase<Unit, Boolean>(dispatcher) {
    override fun execute(parameters: Unit): Flow<Result<Boolean>> =
        dataStoreRepository.read(PreferencesKeys.onBoardingCompletedKey)
}