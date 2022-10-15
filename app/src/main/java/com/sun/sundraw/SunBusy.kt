package com.sun.sundraw

import android.os.Handler
import android.os.Looper

/**
 * @author hengyangji
 * on 2022/10/15
 */
object SunBusy {
    private val sunHandler = Handler(Looper.getMainLooper())

    fun simulateBusy() {
        SunLog.log("开始模拟繁忙")

        for (i in 0 until 10) {
            sunHandler.post {
            SunLog.log("start 繁忙任务，id:${i}")
                Thread.sleep(1000)
            }
        }
    }
}