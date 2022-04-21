package app.play.me.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MusicDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(musicEntity: MusicCacheEntity): Long

    @Query("SELECT * FROM musics")
    suspend fun getMusics(): List<MusicCacheEntity>
}