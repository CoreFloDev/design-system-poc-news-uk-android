package com.example.demoviewcomponent

import android.app.Application
import com.facebook.soloader.SoLoader

class DemoApp : Application() {

    override fun onCreate() {
        super.onCreate()
        // litho init
        SoLoader.init(this, false)
    }
}
