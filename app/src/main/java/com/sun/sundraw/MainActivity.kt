package com.sun.sundraw

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private val mainHandler = Handler(Looper.getMainLooper())

    private val rootView by lazy { findViewById<ViewGroup>(R.id.root) }

    private val sunTextStatic by lazy { findViewById<TextView>(R.id.text_static) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //异步渲染
        val root = findViewById<View>(R.id.root)

        SunLog.log("start pre load")

        SunViewPool.preLoad(this)

//        mainHandler.postDelayed(Runnable {
//            rootView.addView(SunViewPool.sunTextView!!)
//        }, 2000)

        mainHandler.postDelayed(Runnable {
            sunTextStatic.text = "修改文字"
        }, 2000)
    }

    override fun onDestroy() {
        super.onDestroy()
        SunViewPool.destroy()
    }
}