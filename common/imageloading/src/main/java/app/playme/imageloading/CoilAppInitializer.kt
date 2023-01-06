package app.playme.imageloading

import android.app.Application
import app.playme.appinitializers.AppInitializer
import coil.Coil
import coil.ImageLoader
import okhttp3.OkHttpClient
import javax.inject.Inject

class CoilAppInitializer @Inject constructor(
    private val application: Application,
    private val okHttpClient: OkHttpClient

) : AppInitializer {
    override fun init() {
        Coil.setImageLoader {
            ImageLoader.Builder(application)
                .okHttpClient(okHttpClient)
                .build()
        }
    }
}
