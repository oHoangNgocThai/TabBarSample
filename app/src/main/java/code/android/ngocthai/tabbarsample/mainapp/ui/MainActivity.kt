package code.android.ngocthai.tabbarsample.mainapp.ui

import android.os.Bundle
import android.support.annotation.IdRes
import android.support.annotation.NonNull
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import code.android.ngocthai.tabbarsample.R
import code.android.ngocthai.tabbarsample.base.ui.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    companion object {
        private val TAG = MainActivity::class.java.simpleName
    }

    private val tabIcons = listOf(
            R.drawable.ic_home_24dp,
            R.drawable.ic_search_24dp,
            R.drawable.ic_person_24dp)

    override val layoutResource: Int
        get() = R.layout.activity_main

    override fun initComponent(savedInstanceState: Bundle?) {
        setupViewPager(viewPager)
        tabMain.setupWithViewPager(viewPager)
        setupTabIcon()
    }

//    private fun setupTabLayout() {
//        tabMain.addTab(tabMain.newTab().setText("Home").setIcon(R.drawable.ic_home_24dp))
//        tabMain.addTab(tabMain.newTab().setText("Search").setIcon(R.drawable.ic_search_24dp))
//        tabMain.addTab(tabMain.newTab().setText("User").setIcon(R.drawable.ic_person_24dp))
//
//        tabMain.getTabAt(1)?.select()
//        selectedTab(1)
//
//        tabMain.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
//            override fun onTabReselected(tab: TabLayout.Tab?) {
//                Log.d(TAG, "onTabReselected: ${tab?.position}")
//            }
//
//            override fun onTabSelected(tab: TabLayout.Tab?) {
//                Log.d(TAG, "onTabSelected: ${tab?.position}")
//                tab?.let {
//                    selectedTab(it.position)
//                }
//            }
//
//            override fun onTabUnselected(tab: TabLayout.Tab?) {
//                Log.d(TAG, "onTabUnselected: ${tab?.position}")
//            }
//        })
//    }

//    fun selectedTab(position: Int) {
//        when (position) {
//            TabType.HOME.position -> {
//                putFragment(R.id.frameLayoutMain, HomeFragment.getInstance(TabType.HOME.title), TabType.HOME.title)
//            }
//            TabType.SEARCH.position -> {
//                putFragment(R.id.frameLayoutMain, SearchFragment.getInstance(TabType.SEARCH.title), TabType.SEARCH.title)
//            }
//            TabType.USER.position -> {
//                putFragment(R.id.frameLayoutMain, UserFragment.getInstance(TabType.USER.title), TabType.USER.title)
//            }
//        }
//    }

    private fun putFragment(@IdRes container: Int, @NonNull fragment: Fragment, @NonNull tag: String) {
        supportFragmentManager.beginTransaction()
                .replace(container, fragment, tag)
                .disallowAddToBackStack()
                .commit()
    }

    private fun setupTabIcon() {
        tabMain.getTabAt(TabType.HOME.position)?.setIcon(tabIcons[TabType.HOME.position])
        tabMain.getTabAt(TabType.SEARCH.position)?.setIcon(tabIcons[TabType.SEARCH.position])
        tabMain.getTabAt(TabType.USER.position)?.setIcon(tabIcons[TabType.USER.position])
    }

    private fun setupViewPager(viewPager: ViewPager) {
        val pagerAdapter = ViewPagerAdapter(supportFragmentManager)
        pagerAdapter.addFragment(HomeFragment.getInstance("Home Content"), "Home")
        pagerAdapter.addFragment(SearchFragment.getInstance("Search Content"), "Search")
        pagerAdapter.addFragment(UserFragment.getInstance("User Content"), "User")
        viewPager.adapter = pagerAdapter

        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {

            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            }

            override fun onPageSelected(position: Int) {
            }
        })
    }
}
