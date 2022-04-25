package app.play.me.utils

import org.jetbrains.annotations.TestOnly

import org.junit.Test
import com.google.common.truth.Truth.assertThat

class ConstantsTest {
    var BASE_API = "https://playme.herokuapp.com/api/v1/"


    @Test
    fun `base url is correct`() {
        assertThat(Constants.BASE_URL).isEqualTo(BASE_API)
    }

    @Test
    fun`base url is not correct` () {
        assertThat(Constants.BASE_URL).isNotEqualTo("https://playme.herokuapp.com/api/v1")
    }


}