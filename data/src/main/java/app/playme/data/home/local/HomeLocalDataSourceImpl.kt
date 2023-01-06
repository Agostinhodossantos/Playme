package app.playme.data.home.local

import app.playme.model.Music
import javax.inject.Inject

class HomeLocalDataSourceImpl @Inject constructor(

) : HomeLocalDataSource {
    override suspend fun getMusics(): List<Music> {
        return listOf<Music>()
    }
}