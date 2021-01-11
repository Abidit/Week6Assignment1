package Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class Frag_Adapter (
        val list: ArrayList<Fragment>,
        val fragment: FragmentManager,
        val lifecycle: Lifecycle
): FragmentStateAdapter(fragment,lifecycle)

{
    override fun getItemCount(): Int {
        return list.size
    }

    override fun createFragment(position: Int): Fragment {
        return list[position]
    }
}