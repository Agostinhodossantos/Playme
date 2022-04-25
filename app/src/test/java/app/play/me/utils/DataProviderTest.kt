package app.play.me.utils

import org.junit.Assert.*
import com.google.common.truth.Truth.assertThat
import org.junit.Test


class DataProviderTest {

    @Test
    fun `the list must not be empty` () {
        assertThat(DataProvider.getGenreList()).isNotEmpty()
    }

}