package app.play.me.network

import com.skydoves.sandwich.ApiResponse
import com.skydoves.sandwich.SandwichInitializer
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test
import retrofit2.Response
import java.lang.Exception

class ApiResponseTest {

    @Test
    fun exception() {
        val exception = Exception("foo")
        val apiResponse = ApiResponse.error<String>(exception)
        assertThat(apiResponse.message, `is` ("foo"))
    }

    @Test
    fun success() {
        val apiResponse =
            ApiResponse.of(SandwichInitializer.successCodeRange) { Response.success("foo") }
        if (apiResponse is ApiResponse.Success) {
            assertThat(apiResponse.data, `is`("foo"))
        }
    }
}