package com.sun.sundraw

/**
 * Created by hengyangji on 2022/10/12
 */
object SunSimpleTrace {
    private var startTime = 0L
    fun startTrace() {
        startTime = System.currentTimeMillis()
    }

    fun endTrace(tag: String) {
        SunLog.log("$tag cost time:${System.currentTimeMillis() - startTime}")
    }
}