package com.example.homework_2.MVVM.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.lifecycle.SavedStateViewModelFactory
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.homework_2.MVVM.viewmodel.MainViewModel
import com.example.homework_2.R
import com.example.homework_2.StatusLoad

class MainFragment : Fragment()
{
    private lateinit var mainViewModel: MainViewModel

    private val mainAdapter = MainAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View
    {
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)

        mainViewModel = ViewModelProvider(requireActivity(), SavedStateViewModelFactory())[MainViewModel::class.java]

        view.findViewById<RecyclerView>(R.id.recycler).apply {
            layoutManager = LinearLayoutManager(context)
            adapter = mainAdapter
        }

        mainViewModel.items.observe(viewLifecycleOwner) {
            mainAdapter.addList(it)
            mainAdapter.notifyDataSetChanged()
        }

        mainViewModel.status.observe(viewLifecycleOwner) {
            when (it) {
                StatusLoad.SUCCESS -> {}
                StatusLoad.ERROR -> {}
            }
        }
    }
}