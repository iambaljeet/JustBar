package com.app.justbar

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.ViewPager

class ParralaxViewPagerTransformer: ViewPager.PageTransformer {
    override fun transformPage(page: View, position: Float) {
        if(position >= -1 && position <= 1){
            page.findViewById<ImageView>(R.id.imageView_icon).translationX = -position * page.width / 5
            page.findViewById<TextView>(R.id.textView_description).translationX = position * page.width / 8
        } else {
            page.alpha = 1f
        }
    }
}