package com.example.confilct

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.viewpager.widget.ViewPager
import kotlin.math.abs

class MyViewPager @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : ViewPager(context, attrs) {

    /*  内部拦截法
        override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
            if (ev?.action == MotionEvent.ACTION_DOWN) {
                super.onInterceptTouchEvent(ev)
                return false
            }
            return true
        }
    */
    private var mLastX = 0f;
    private var mLastY = 0f;
    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {

        super.onInterceptTouchEvent(ev)
        ev?.let {
            when (it.action) {
                MotionEvent.ACTION_DOWN -> {
                    mLastX = ev.x
                    mLastY = ev.y
                }

                MotionEvent.ACTION_MOVE -> {
                    if (abs(ev.x - mLastX) > abs(ev.y - mLastY)) {
                        return true
                    }
                }
            }

        }
        return false
    }

}