package app.playme.domain.usecases

import app.playme.data.home.repository.HomeRepository
import app.playme.domain.SuspendUseCase
import app.playme.inject.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import javax.inject.Inject

class InitHomeUseCase @Inject constructor(
    private val homeRepository: HomeRepository,
    @IoDispatcher ioDispatcher: CoroutineDispatcher
) : SuspendUseCase<Unit, Unit>(ioDispatcher) {
    override suspend fun execute(parameters: Unit): Unit = coroutineScope {
        val musics = async { homeRepository.getMusics() }
        val albums = async { homeRepository.getAlbums() }
        musics.await()
        albums.await()
    }

}