package com.app.justbar

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class TutorialViewPagerAdapter(fragmentManager: FragmentManager) : FragmentStatePagerAdapter(fragmentManager) {
    private val tutorialList = mutableListOf(
        TutorialDataModel(R.drawable.tutorial_image_1, "It’s available in your favorite cities now\n" +
                "and thy wait! go and order \n" +
                "four favorite juices"),
        TutorialDataModel(R.drawable.tutorial_image_2, "Juice is a beverage made from the \n" +
                "extraction or pressing out of natural liquid\n" +
                "contained good quality fruits"),
        TutorialDataModel(R.drawable.tutorial_image_3, "User can look for their favorite juices\n" +
                "and buy it through the online gateway\n" +
                "process or through cash on delivery")
    )

    override fun getItem(position: Int): Fragment {
        return TutorialFragment.newInstance(tutorialList[position].image, tutorialList[position].title)
    }

    override fun getCount(): Int {
        return tutorialList.size
    }
}