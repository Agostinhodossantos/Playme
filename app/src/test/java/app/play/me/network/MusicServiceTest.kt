package app.play.me.network

import app.play.me.MainCoroutinesRule
import com.skydoves.sandwich.ApiResponse
import kotlinx.coroutines.MainCoroutineDispatcher
import kotlinx.coroutines.runBlocking
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MusicServiceTest : ApiAbstract<MusicApi>() {

    private lateinit var service : MusicApi

    @get:Rule
    val coroutineRule = MainCoroutinesRule()

    @Before
    fun initService() {
        service  = createService(MusicApi::class.java)
    }

    @Test
    fun fetchMusicListFromNetworkTest() = runBlocking {
        enqueueResponse("musicResponse.json")
        val response = service.getMusic()
        val responseBody = requireNotNull((response as ApiResponse.Success<MusicObjectResponse>).data)
        mockWebServer.takeRequest()

        assertThat(responseBody.id, CoreMatchers.`is`(0))

    }

}