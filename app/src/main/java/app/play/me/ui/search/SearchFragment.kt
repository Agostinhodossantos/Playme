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
import app.play.me.databinding.FragmentSearchBinding
import app.play.me.model.TopMusic
import app.play.me.ui.home.MostPlayedAdapter

class SearchFragment : Fragment() {

    private lateinit var premiumViewModel: PremiumViewModel
    private var _binding: FragmentSearchBinding? = null

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

        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val adapter = MostPlayedAdapter()

        adapter.submitList(getTopMusic())
        binding.rvToDoList.layoutManager =
            StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
        binding.rvToDoList.adapter = adapter


        return root
    }

    private fun getTopMusic(): List<TopMusic> {
        var list = mutableListOf<TopMusic>()
        list.add(TopMusic(1, "Today's Top Hits", "", true))
        list.add(TopMusic(1, "This is Justin bieber", "", ))
        list.add(TopMusic(1, "All Out 2010s", ""))
        list.add(TopMusic(1, "Mega Hit Mix", ""))
        list.add(TopMusic(1, "Make me better", ""))
        list.add(TopMusic(1, "Impact Theory with Tom", ""))
        list.add(TopMusic(1, "Impact Theory with Tom", ""))
        list.add(TopMusic(1, "Mega Hit Mix", ""))
        list.add(TopMusic(1, "Make me better", ""))
        list.add(TopMusic(1, "Impact Theory with Tom", ""))
        list.add(TopMusic(1, "Impact Theory with Tom", ""))
        list.add(TopMusic(1, "This is Justin bieber", "", ))
        list.add(TopMusic(1, "All Out 2010s", ""))
        list.add(TopMusic(1, "Mega Hit Mix", ""))
        list.add(TopMusic(1, "Make me better", ""))
        list.add(TopMusic(1, "Impact Theory with Tom", ""))
        list.add(TopMusic(1, "Impact Theory with Tom", ""))
        list.add(TopMusic(1, "Mega Hit Mix", ""))
        list.add(TopMusic(1, "Make me better", ""))
        list.add(TopMusic(1, "Impact Theory with Tom", ""))
        list.add(TopMusic(1, "Impact Theory with Tom", ""))
        list.add(TopMusic(1, "This is Justin bieber", "", ))
        list.add(TopMusic(1, "All Out 2010s", ""))
        list.add(TopMusic(1, "Mega Hit Mix", ""))
        list.add(TopMusic(1, "Make me better", ""))
        list.add(TopMusic(1, "Impact Theory with Tom", ""))
        list.add(TopMusic(1, "Impact Theory with Tom", ""))
        list.add(TopMusic(1, "Mega Hit Mix", ""))
        list.add(TopMusic(1, "Make me better", ""))
        list.add(TopMusic(1, "Impact Theory with Tom", ""))
        list.add(TopMusic(1, "Impact Theory with Tom", ""))
        list.add(TopMusic(1, "This is Justin bieber", "", ))
        list.add(TopMusic(1, "All Out 2010s", ""))
        list.add(TopMusic(1, "Mega Hit Mix", ""))
        list.add(TopMusic(1, "Make me better", ""))
        list.add(TopMusic(1, "Impact Theory with Tom", ""))
        list.add(TopMusic(1, "Impact Theory with Tom", ""))
        list.add(TopMusic(1, "Mega Hit Mix", ""))
        list.add(TopMusic(1, "Make me better", ""))
        list.add(TopMusic(1, "Impact Theory with Tom", ""))
        list.add(TopMusic(1, "Impact Theory with Tom", ""))

        return list
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}