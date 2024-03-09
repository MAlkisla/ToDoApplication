package com.example.todoapplication.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.todoapplication.databinding.FragmentTodoAddBinding
import com.example.todoapplication.ui.viewmodel.TodoAddViewModel

class TodoAddFragment : Fragment() {
    private lateinit var binding: FragmentTodoAddBinding
    private lateinit var viewModel: TodoAddViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTodoAddBinding.inflate(inflater, container, false)

        binding.buttonAdd.setOnClickListener {
            val todo_name = binding.editTextTodoName.text.toString()
            viewModel.add(todo_name)
        }

        return binding.root
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: TodoAddViewModel by viewModels()
        viewModel = tempViewModel
    }
}