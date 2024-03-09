package com.example.todoapplication.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView.OnQueryTextListener
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.todoapplication.R
import com.example.todoapplication.data.entity.Todos
import com.example.todoapplication.databinding.FragmentHomepageBinding
import com.example.todoapplication.ui.adapter.TodosAdapter
import com.example.todoapplication.ui.viewmodel.HomepageViewModel
import com.example.todoapplication.utils.migration

class HomepageFragment : Fragment() {
    private lateinit var binding: FragmentHomepageBinding
    private lateinit var viewModel: HomepageViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomepageBinding.inflate(inflater, container, false)

        viewModel.todosList.observe(viewLifecycleOwner) {
            val todosAdapter = TodosAdapter(requireContext(), it, viewModel)
            binding.todosRv.adapter = todosAdapter
        }

        binding.todosRv.layoutManager = LinearLayoutManager(requireContext())
        /*binding.todosRv.layoutManager = StaggeredGridLayoutManager(
            1, StaggeredGridLayoutManager
                .VERTICAL
        )*/

        binding.fab.setOnClickListener {
            Navigation.migration(it,R.id.todoAddFragment)
        }


        binding.searchView.setOnQueryTextListener(object : OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                viewModel.search(query)
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                viewModel.search(newText)
                return true
            }
        })

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: HomepageViewModel by viewModels()
        viewModel = tempViewModel
    }

    override fun onResume() {
        super.onResume()
        viewModel.loadTodos()
    }
}