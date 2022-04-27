package app.play.me.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import app.play.me.databinding.FragmentHomeBinding
import app.play.me.databinding.FragmentPremiumBinding
import app.play.me.ui.adapter.MostPlayedAdapter
import app.play.me.ui.home.HomeViewModel

class PremiumFragment : Fragment() {

    private lateinit var premiumViewModel: PremiumViewModel
    private var _binding: FragmentPremiumBinding? = null

    private lateinit var homeViewModel: HomeViewModel
    val adapter = MostPlayedAdapter()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        premiumViewModel =
            ViewModelProvider(this).get(PremiumViewModel::class.java)

        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentPremiumBinding.inflate(inflater, container, false)
        val root: View = binding.root

        premiumViewModel.text.observe(viewLifecycleOwner, Observer {
        })


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}