package com.fleme.myfoods.presentation.recipes.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.fleme.myfoods.R
import com.fleme.myfoods.presentation.recipes.DemoObjectFragment
import com.fleme.myfoods.presentation.recipes.fragments.PageFragment
import com.fleme.myfoods.presentation.recipes.fragments.PageFragment2

private const val ARG_OBJECT = "object"

class DemoCollectionAdapter2(
    fragmentManager: FragmentManager,
    private val list: List<String>
) : FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val fragmentList = arrayListOf<PageFragment2>()

    init {
        list.forEach {
            fragmentList.add(PageFragment2.newInstance(it))
        }
    }

    override fun getItem(position: Int) = fragmentList[position]

    override fun getCount() = list.size
}


//class DemoCollectionAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
//
//    override fun getItemCount(): Int = 4
//
//    override fun createFragment(position: Int): Fragment {
//        // Return a NEW fragment instance in createFragment(int)
//        val fragment = DemoObjectFragment()
//        fragment.arguments = Bundle().apply {
//            // Our object is just an integer :-P
//            putInt(ARG_OBJECT, position + 1)
//        }
//        return fragment
//    }
//}