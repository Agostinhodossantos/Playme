package app.play.me.database

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider.getApplicationContext
import com.google.gson.GsonBuilder
import com.squareup.moshi.Moshi
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [21])
abstract class LocalDatabase {
    lateinit var db: MusicDatabase

    @Before
    fun initDB() {
        db = Room.inMemoryDatabaseBuilder(getApplicationContext(), MusicDatabase::class.java)
            .allowMainThreadQueries()
            .build()

    }

    @After
    fun closeDB() {
        db.close()
    }


}