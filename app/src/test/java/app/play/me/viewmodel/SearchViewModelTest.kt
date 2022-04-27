package app.play.me.viewmodel

import android.widget.SearchView
import app.play.me.MainCoroutinesRule
import app.play.me.common.MockUtil
import app.play.me.database.CacheMapper
import app.play.me.database.MusicDao
import app.play.me.network.MusicApi
import app.play.me.network.MusicMapper
import app.play.me.repository.MainRepository
import app.play.me.ui.library.LibraryViewModel
import app.play.me.ui.search.SearchViewModel
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class SearchViewModelTest {

    private lateinit var viewModel: LibraryViewModel
    private lateinit var mainRepository: MainRepository
    private lateinit var cacheMapper: CacheMapper
    private lateinit var musicMapper: MusicMapper
    private val service: MusicApi = mock()
    private val musicDao : MusicDao = mock()

    @get:Rule
    val coroutinesRule = MainCoroutinesRule()


    @Before
    fun setup() {
        mainRepository = MainRepository(musicDao, service, cacheMapper, musicMapper)
        viewModel = LibraryViewModel(mainRepository)
    }

    @Test
    fun fetchMusicListTest() = runTest {
        val mockData = MockUtil.mockMusicList()
            //TODO Fix this  whenever(musicDao.getMusics()).thenReturn(mockData)
    }

}


















