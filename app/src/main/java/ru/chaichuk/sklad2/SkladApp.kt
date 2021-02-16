package ru.chaichuk.sklad2

import android.app.Application
import android.content.Context
import coil.ImageLoader
import coil.ImageLoaderFactory
import coil.util.CoilUtils
import okhttp3.OkHttpClient
import ru.chaichuk.sklad2.db.SkladDbRepository

class SkladApp : Application(), ImageLoaderFactory {

    companion object {
        private lateinit var appContext: Context
        private lateinit var dbRepository: SkladDbRepository

        fun appContext(): Context {
            return appContext
        }

        fun appSkladDbRepository(): SkladDbRepository {
            return dbRepository
        }
    }

    override fun onCreate() {
        super.onCreate()
        appContext = this.applicationContext
        dbRepository = SkladDbRepository(appContext)

    }

    override fun newImageLoader(): ImageLoader {
        return ImageLoader.Builder(applicationContext)
            .crossfade(true)
            .okHttpClient {
                OkHttpClient.Builder()
                    .cache(CoilUtils.createDefaultCache(applicationContext))
                    .build()
            }
            .build()
    }
}
