package com.sun.sundraw

import android.os.Handler
import android.os.HandlerThread
import android.view.Choreographer

/**
 * @author hengyangji
 * on 2022/10/15
 */
object SunFps {
    private val fpsHandler: Handler by lazy {
        Handler(HandlerThread("fpsHandlerThread").run {
            start()
            looper
        })
    }

    fun calculateFps() {
        callFrameCallback()
    }

    private fun callFrameCallback() {
        Choreographer.getInstance().postFrameCallback {
            SunLog.log("do frame callback")
            fpsHandler.postDelayed({ callFrameCallback() }, 50)
        }
    }
}