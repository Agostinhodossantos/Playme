package app.playme.domain.usecases

import javax.inject.Inject

class OnBoardingCompletedUseCase @Inject constructor(
    private val dataStoreRepository: DataStoreOperations,
) {
}