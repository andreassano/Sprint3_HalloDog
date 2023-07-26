package com.example.sprint3_hallodog.ui.profile

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.sprint3_hallodog.ui.profile.akun.ProfileAkunFragment
import com.example.sprint3_hallodog.ui.profile.lainnya.ProfileLainnyaFragment
import com.google.android.material.tabs.TabLayout

class SectionPagerAdapter(fm: FragmentManager, private val tabLayout: TabLayout) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position) {
            0 -> "Akun Saya"
            1 -> "Lainnya"
            else -> ""
        }
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getItem(position: Int): Fragment {
        var fragment : Fragment

        return  when(position) {
            0 -> {
                fragment = ProfileAkunFragment()
                return fragment
            }
            1 -> {
                fragment = ProfileLainnyaFragment()
                return fragment
            }
            else -> {
                fragment = ProfileAkunFragment()
                return fragment
            }
        }

    }

}