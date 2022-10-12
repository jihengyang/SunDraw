package com.sun.sundraw

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout

/**
 * Created by hengyangji on 2022/10/12
 */
class SunComplexUI @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : FrameLayout(context, attrs) {
    init {
        LayoutInflater.from(context).inflate(R.layout.sun_complex_ui, this, true)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        SunLog.log("SunComplexUI onMeasure")
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
        SunLog.log("SunComplexUI onLayout")
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        SunLog.log("SunComplexUI onDraw")
    }

}