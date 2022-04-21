package app.play.me.database

import androidx.room.Database
import androidx.room.RoomDatabase
import app.play.me.model.Music

@Database(entities = [MusicCacheEntity::class], version = 1)
abstract class MusicDatabase : RoomDatabase() {
    abstract fun musicDao(): MusicDao

    companion object {
        const val DATABASE_NAME: String = "music_db"
    }
}