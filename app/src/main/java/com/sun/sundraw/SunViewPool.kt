package com.sun.sundraw

import android.content.Context
import android.os.Handler
import android.os.HandlerThread

/**
 * Created by hengyangji on 2022/10/12
 */
object SunViewPool {
    private var sunHandlerThread: HandlerThread? = null

    private var sunHandler: Handler? = null
//    private val sunViewHandlerThread by lazy {
//        HandlerThread("SunViewHT").apply {
//            start()
//        }
//    }

//    private val sunHandler by lazy { Handler(sunViewHandlerThread.looper) }

    var sunTextView: SunTextView? = null

    var sunComplexUIView: SunComplexUI? = null

    fun preLoad(context: Context) {
        if (sunHandlerThread == null) {
            sunHandlerThread = HandlerThread("SunViewHT").apply {
                start()
            }
        }
        SunLog.log("sunHandlerThread isAlive:${sunHandlerThread!!.isAlive}")
        if (sunHandler == null) {
            sunHandler = Handler(sunHandlerThread!!.looper)
        }

        if (sunTextView == null) {
            sunHandler!!.post {
                sunTextView = SunTextView(context)
                sunTextView!!.text = "预加载内容"
            }
        }
        if (sunComplexUIView == null) {
            sunHandler!!.post {
                SunLog.log("start pre load complex ui thread:${Thread.currentThread().name}")
                SunSimpleTrace.startTrace()
                sunComplexUIView = SunComplexUI(context)
                SunSimpleTrace.endTrace("SunComplexUI create")
            }
        }
    }

    fun destroy() {
        sunHandlerThread?.quit()
        sunHandlerThread = null
        sunHandler?.removeCallbacksAndMessages(null)
        sunHandler = null
        sunTextView = null
    }
}