package app.play.me.database;


import app.play.me.common.MockUtil.mockMusic
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.runBlocking
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [21])
public class MusicDaoTest : LocalDatabase() {
    private lateinit var musicDao: MusicDao
    private lateinit var cacheMapper: CacheMapper

    @Before
    fun init() {
        musicDao = db.musicDao()
        cacheMapper = CacheMapper()
    }


    @Test
    fun insertAndLoadMusics() = runBlocking {
        val mockMusic = cacheMapper.mapToEntity(mockMusic())
        musicDao.insert(mockMusic)

        val loadFromDB = musicDao.getMusics()
        assertThat(loadFromDB[0].toString(),`is` (mockMusic.toString()) )
    }
}
