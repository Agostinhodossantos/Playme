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
        enqueueResponse("/MusicResponse.json")
        val response = service.getMusic()
        print(response[0].url)
        val responseBody = requireNotNull((response[0] as ApiResponse.Success<Any>).data)
        mockWebServer.takeRequest()
//
//        assertThat(responseBody[0].id, `is`(0))
//        assertThat(responseBody[0].url, `is`("url"))
        println(responseBody)

    }

}