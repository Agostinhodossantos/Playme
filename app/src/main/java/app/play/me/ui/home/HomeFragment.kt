package app.play.me.ui.home

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
import app.play.me.R
import app.play.me.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null
    val adapter = MostPlayedAdapter()
    var mixesAdapter = TopMixesAdapter()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root


        homeViewModel.topMusic.observe(viewLifecycleOwner) {
            adapter.submitList(it)
            binding.rvMostPlayed.layoutManager =
                StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
            binding.rvMostPlayed.adapter = adapter

            mixesAdapter.submitList(it)
            binding.rvTopMixes.layoutManager =
                StaggeredGridLayoutManager(1, LinearLayoutManager.HORIZONTAL)
            binding.rvTopMixes.adapter = mixesAdapter


        }


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}