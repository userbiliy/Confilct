package com.example.confilct

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.ViewGroup
import android.widget.ListView
import kotlin.math.abs

// 自定义的 MyListView，这里简化为直接继承 ListView
class MyListView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ListView(context, attrs, defStyleAttr) {
    /*  内部拦截法
        private var mLastX = 0f;
        private var mLastY = 0f;
        override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {

            ev?.let {
                when (it.action) {
                    MotionEvent.ACTION_DOWN -> {
                        /* 这种方法并不能保证`Down`事件不会被父容器拦截，`Down`事件会重置状态 */
                        parent.requestDisallowInterceptTouchEvent(true)
                        mLastX = ev.x
                        mLastY = ev.y
                    }

                    MotionEvent.ACTION_MOVE -> {
                        if (abs(ev.x - mLastX) > abs(ev.y - mLastY)) {
                            parent.requestDisallowInterceptTouchEvent(false)
                        }
                    }
                }

            }
            return super.dispatchTouchEvent(ev)
        }
    */
}