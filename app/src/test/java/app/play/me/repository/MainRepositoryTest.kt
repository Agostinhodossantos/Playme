package app.play.me.repository

import app.play.me.MainCoroutinesRule
import app.play.me.common.MockUtil.mockMusicList
import app.play.me.database.CacheMapper
import app.play.me.database.MusicDao
import app.play.me.network.MusicApi
import app.play.me.network.MusicMapper
import app.play.me.network.MusicObjectResponse
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MainRepositoryTest {

    private lateinit var repository: MainRepository
    private lateinit var cacheMapper: CacheMapper
    private lateinit var musicMapper: MusicMapper
    private val service: MusicApi = mock()
    private val musicDao : MusicDao = mock()


    @get:Rule
    val coroutinesRule = MainCoroutinesRule()

    @Before
    fun setup() {
        cacheMapper = CacheMapper()
        musicMapper = MusicMapper()
        repository = MainRepository(musicDao, service, cacheMapper, musicMapper)
    }

    @Test
    fun fetchMusicListFromNetworkTest() = runTest {
        val mockData = mockMusicList()

        whenever(musicDao.getMusics()).thenReturn(emptyList())

    }

}