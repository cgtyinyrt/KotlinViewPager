package com.cagatayinyurt.kotlinviewpager

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class CollectionDemoFragment : Fragment() {

    private lateinit var viewPager2: ViewPager2
    private lateinit var demoCollectionAdapter: DemoCollectionAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_collection_demo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        demoCollectionAdapter = DemoCollectionAdapter(this)
        viewPager2 = view.findViewById(R.id.viewPager2)
        viewPager2.adapter = demoCollectionAdapter

        val tabLayout = view.findViewById<TabLayout>(R.id.tabLayout)
        TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
            tab.text = "Object ${(position + 1)}"
        }.attach()
    }
}