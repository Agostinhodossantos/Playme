package app.play.me.network

import app.play.me.MainCoroutinesRule
import com.skydoves.sandwich.ApiResponse
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.MainCoroutineDispatcher
import kotlinx.coroutines.runBlocking
import org.hamcrest.CoreMatchers
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import java.io.IOException

@ExperimentalCoroutinesApi
class MusicServiceTest : ApiAbstract<MusicApi>() {

    private lateinit var service : MusicApi

    @ExperimentalCoroutinesApi
    @get:Rule
    val coroutineRule = MainCoroutinesRule()

    @Before
    fun initService() {
        service  = createService(MusicApi::class.java)
    }

    @Throws(IOException::class)
    @Test
    fun fetchMusicListFromNetworkTest() = runBlocking {
        enqueueResponse("/musicResponse.json")
        val response = service.getMusic()
        val responseBody = requireNotNull((response as ApiResponse.Success<MusicObjectResponse>).data)
        mockWebServer.takeRequest()

        assertThat(responseBody.id, `is`(0))
        assertThat(responseBody.url, `is`("url"))
        println(responseBody)

    }

}