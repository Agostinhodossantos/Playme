package app.playme.data.home.local

interface HomeLocalDataSource {
    suspend fun getMusics(): List<Music>
}