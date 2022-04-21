package app.play.me.di

import android.content.Context
import androidx.room.Room
import app.play.me.database.MusicDao
import app.play.me.database.MusicDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Singleton
    @Provides
    fun provideMusicDb(@ApplicationContext context: Context): MusicDatabase {
        return Room.databaseBuilder(
            context, MusicDatabase::class.java,
            MusicDatabase.DATABASE_NAME
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideMusicDAO(musicDatabase: MusicDatabase): MusicDao {
        return musicDatabase.musicDao()
    }
}