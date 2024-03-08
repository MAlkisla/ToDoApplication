package com.example.todoapplication.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView.OnQueryTextListener
import androidx.navigation.Navigation
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.todoapplication.R
import com.example.todoapplication.data.entity.Todos
import com.example.todoapplication.databinding.FragmentHomepageBinding
import com.example.todoapplication.ui.adapter.TodosAdapter

class HomepageFragment : Fragment() {
    private lateinit var binding: FragmentHomepageBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomepageBinding.inflate(inflater, container, false)

        val todosList = ArrayList<Todos>()

        val t1= Todos(1,"empty")
        val t2= Todos(2,"null")
        val t3= Todos(3,"full")
        todosList.add(t1)
        todosList.add(t2)
        todosList.add(t3)

        val todosAdapter= TodosAdapter(requireContext(),todosList)
        binding.todosRv.adapter = todosAdapter

        //binding.todosRv.layoutManager = LinearLayoutManager(requireContext())
        binding.todosRv.layoutManager = StaggeredGridLayoutManager(1,StaggeredGridLayoutManager
            .VERTICAL)

        binding.fab.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.todoAddFragment)
        }


        binding.searchView.setOnQueryTextListener(object : OnQueryTextListener{
            override fun onQueryTextSubmit(query: String): Boolean {
                search(query)
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                search(newText)
                return true
            }
        })

        return binding.root
    }

    fun search(searchWord:String){
        Log.e("To-do Search",searchWord)
    }
}