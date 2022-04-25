package app.play.me.utils

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class DataStateTest {

    @Test
    fun `must return List of data` () {
        var list = listOf("test")
        var dataState = DataState.Success(list)

        assertThat(dataState.data).isEqualTo(list)
    }

}