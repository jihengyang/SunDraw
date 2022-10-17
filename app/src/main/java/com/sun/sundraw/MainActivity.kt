package com.sun.sundraw

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val mainHandler = Handler(Looper.getMainLooper())

    private val rootView by lazy { findViewById<ViewGroup>(R.id.root) }

//    private val sunTextStatic by lazy { findViewById<TextView>(R.id.text_static) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //异步渲染
        SunViewPool.preLoad(this)
//        mainHandler.postDelayed(Runnable {
//            rootView.addView(SunViewPool.sunTextView!!)
//        }, 2000)

//        mainHandler.postDelayed(Runnable {
//            SunSimpleTrace.startTrace()
//            sunTextStatic.text = "修改文字"
//            SunSimpleTrace.endTrace("set text")
//        }, 2000)

//        showList()
        findViewById<View>(R.id.perform_travel).setOnClickListener {
//            it.invalidate()
            rootView.addView(SunViewPool.sunTextView!!)
        }

//        mainHandler.postDelayed({
//            SunBusy.simulateBusy()
//        }, 2000)
//        SunFps.calculateFps()
    }

//    private fun showList() {
//        findViewById<RecyclerView>(R.id.recyclerview).run {
//            layoutManager = LinearLayoutManager(context)
//            adapter = object : RecyclerView.Adapter<SunViewHolder>() {
//                override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SunViewHolder {
//                    return SunViewHolder(SunTextView(context).apply {
//                        text = "1"
//                        minHeight = 100
//                        textSize = 20f
//                        setOnClickListener {
//                            it.invalidate()
//                        }
//                        layoutParams = RecyclerView.LayoutParams(
//                            ViewGroup.LayoutParams.MATCH_PARENT,
//                            ViewGroup.LayoutParams.WRAP_CONTENT
//                        )
//                    })
//                }
//
//                override fun onBindViewHolder(holder: SunViewHolder, position: Int) {
//                    (holder.itemView as TextView).text = position.toString()
//                }
//
//                override fun getItemCount() = 100
//            }
//        }
//    }

    class SunViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        return super.dispatchTouchEvent(ev)
    }

    override fun onDestroy() {
        super.onDestroy()
        SunViewPool.destroy()
    }
}