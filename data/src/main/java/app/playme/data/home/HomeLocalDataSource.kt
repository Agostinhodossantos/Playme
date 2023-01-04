package app.playme.data.home

interface HomeLocalDataSource {
    suspend fun getMusics()
}