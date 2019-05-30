package code.android.ngocthai.tabbarsample

import android.os.Bundle
import android.support.v4.view.ViewPager
import code.android.ngocthai.tabbarsample.base.ui.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override val layoutResource: Int
        get() = R.layout.activity_main

    override fun initComponent(savedInstanceState: Bundle?) {
        setupViewPager(viewPagerMain)
        tabMain.setupWithViewPager(viewPagerMain)
    }

    private fun setupViewPager(viewPager: ViewPager) {
        val pagerAdapter = ViewPagerAdapter(supportFragmentManager)
        pagerAdapter.addFragment(HomeFragment.getInstance("Home Content"), "Home")
        pagerAdapter.addFragment(SearchFragment.getInstance("Search Content"), "Search")
        pagerAdapter.addFragment(UserFragment.getInstance("User Content"), "User")
        viewPager.adapter = pagerAdapter
    }
}
