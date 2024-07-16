package com.example.confilct

import MyAdapter
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager.widget.PagerAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val myViewPager = findViewById<MyViewPager>(R.id.myViewPager)

        // 创建一个适配器并设置给 ViewPager
        val adapter = MyViewPagerAdapter(getImageResources())
        myViewPager.adapter = adapter
    }

    // 假设这里是获取图片资源的方法
    private fun getImageResources(): List<List<Int>> {
        // 假设每一页的数据不同
        return listOf(
            listOf(
                R.drawable.yc1,
                R.drawable.biluo1,
                R.drawable.yc2,
                R.drawable.biluo2,
                R.drawable.yc3
            ),
            listOf(
                R.drawable.yc2,
                R.drawable.biluo2,
                R.drawable.yc3,
                R.drawable.biluo1,
                R.drawable.yc4
            ),
            listOf(
                R.drawable.yc3,
                R.drawable.biluo1,
                R.drawable.yc4,
                R.drawable.biluo2,
                R.drawable.yc1
            )
            // 添加更多页面的图片资源
        )
    }

    // 自定义 ViewPager 的适配器
    inner class MyViewPagerAdapter(private val imageResourcesList: List<List<Int>>) :
        PagerAdapter() {

        override fun getCount(): Int {
            return imageResourcesList.size
        }

        override fun isViewFromObject(view: View, `object`: Any): Boolean {
            return view === `object`
        }

        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            val listView = MyListView(container.context)
            listView.adapter = MyAdapter(container.context, imageResourcesList[position])
            container.addView(listView)
            return listView
        }

        override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
            container.removeView(`object` as MyListView)
        }
    }
}