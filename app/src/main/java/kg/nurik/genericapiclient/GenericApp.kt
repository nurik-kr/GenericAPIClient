package kg.nurik.genericapiclient

import android.app.Application
import kg.nurik.genericapiclient.di.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class GenericApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@GenericApp)
            modules(appModules)
        }
    }

}