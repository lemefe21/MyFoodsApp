package com.fleme.myfoods.presentation.recipes.custom

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.viewpager.widget.ViewPager

class CustomPager @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
): ViewPager(context, attrs) {

    var customPager: CustomPager? = null
    var forSuper: Boolean = false

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        if(!forSuper) {
            customPager?.forSuper = true
            customPager?.onInterceptTouchEvent(ev)
            customPager?.forSuper = false
        }

        return super.onInterceptTouchEvent(ev)
    }

    override fun onTouchEvent(ev: MotionEvent?): Boolean {
        if(!forSuper) {
            customPager?.forSuper = true
            customPager?.onInterceptTouchEvent(ev)
            customPager?.forSuper = false
        }
        return super.onTouchEvent(ev)
    }

    override fun setCurrentItem(item: Int, smoothScroll: Boolean) {
        if(!forSuper) {
            customPager?.forSuper = true
            customPager?.setCurrentItem(item, smoothScroll)
            customPager?.forSuper = false
        }

        super.setCurrentItem(item, smoothScroll)
    }

    override fun setCurrentItem(item: Int) {
        if(!forSuper) {
            customPager?.forSuper = true
            customPager?.currentItem = item
            customPager?.forSuper = false
        }

        super.setCurrentItem(item)
    }
}