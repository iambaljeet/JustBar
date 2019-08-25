package com.app.justbar

import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var dotsCount: Int = 0
    private var dots: MutableList<ImageView> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {
        val viewPagerAdapter = TutorialViewPagerAdapter(supportFragmentManager)
        viewPager_tutorial?.adapter = viewPagerAdapter
        viewPager_tutorial.setPageTransformer(false, ParralaxViewPagerTransformer())

        setupViewPagerIndicator(viewPagerAdapter)

        viewPager_tutorial?.addOnPageChangeListener(
            object : ViewPager.OnPageChangeListener {
                override fun onPageScrollStateChanged(state: Int) {
                }

                override fun onPageScrolled(
                    position: Int,
                    positionOffset: Float,
                    positionOffsetPixels: Int
                ) {
                }

                override fun onPageSelected(position: Int) {
                    for (i in 0 until dotsCount) {
                        dots[i].setImageDrawable(
                            ContextCompat.getDrawable(
                                applicationContext,
                                R.drawable.indicator_inactive
                            )
                        )
                    }
                    dots[position].setImageDrawable(ContextCompat.getDrawable(applicationContext, R.drawable.indicator_active))
                }
            }
        )
    }

    private fun setupViewPagerIndicator(viewPagerAdapter: TutorialViewPagerAdapter) {
        dotsCount = viewPagerAdapter.count

        for (i in 0 until dotsCount) {
            dots.add(i, ImageView(this))
            dots[i].setImageDrawable(
                ContextCompat.getDrawable(
                    applicationContext,
                    R.drawable.indicator_inactive
                )
            )

            val params = LinearLayout.LayoutParams(
                100,
                30
            )

            params.setMargins(25, 0, 25, 0)

            linearLayout_indicator.addView(dots[i], params)
        }

        dots[0].setImageDrawable(
            ContextCompat.getDrawable(
                applicationContext,
                R.drawable.indicator_active
            )
        )
    }
}
