package com.sun.sundraw

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.widget.TextView

/**
 * Created by hengyangji on 2022/10/12
 */
@SuppressLint("AppCompatCustomView")
class SunTextView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : TextView(context, attrs) {
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        SunSimpleTrace.startTrace()
        val sourceWidth = MeasureSpec.getSize(widthMeasureSpec)
        val sourceHeight = MeasureSpec.getSize(heightMeasureSpec)
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        SunLog.log("$name onMeasure, sourceWidth:$sourceWidth, sourceHeight:$sourceHeight")
        SunSimpleTrace.endTrace("$name onMeasure")
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        SunSimpleTrace.startTrace()
        super.onLayout(changed, left, top, right, bottom)
        SunLog.log("$name onLayout")
        SunSimpleTrace.endTrace("$name onLayout")
    }

    override fun onDraw(canvas: Canvas?) {
        SunSimpleTrace.startTrace()
        super.onDraw(canvas)
        SunLog.log("$name onDraw")
        SunSimpleTrace.endTrace("$name onDraw")
    }

    private val name: String
        get() {
            return "SunTextView$text"
        }
}