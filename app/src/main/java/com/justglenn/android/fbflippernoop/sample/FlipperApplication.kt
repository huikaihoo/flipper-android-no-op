package com.justglenn.android.fbflippernoop.sample

import android.app.Application
import com.facebook.flipper.android.AndroidFlipperClient
import com.facebook.flipper.android.utils.FlipperUtils
import com.facebook.flipper.plugins.inspector.DescriptorMapping
import com.facebook.flipper.plugins.inspector.InspectorFlipperPlugin
import com.facebook.flipper.plugins.network.NetworkFlipperPlugin
import com.facebook.soloader.SoLoader

class FlipperApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        SoLoader.init(this, false)

        installFlipper()
    }

    private fun installFlipper() {
        if (BuildConfig.DEBUG && FlipperUtils.shouldEnableFlipper(this)) {
            AndroidFlipperClient.getInstance(this).apply {
                addPlugin(NetworkFlipperPlugin())
                addPlugin(InspectorFlipperPlugin(this@FlipperApplication, DescriptorMapping.withDefaults()))
                start()
            }
        }
    }
}