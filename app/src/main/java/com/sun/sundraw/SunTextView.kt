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
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        SunLog.log("SunTextView onMeasure")
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
        SunLog.log("SunTextView onLayout")
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        SunLog.log("SunTextView onDraw")
    }

}