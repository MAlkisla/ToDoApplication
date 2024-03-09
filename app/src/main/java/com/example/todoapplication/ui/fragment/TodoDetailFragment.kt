package com.example.todoapplication.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.todoapplication.databinding.FragmentTodoDetailBinding
import com.example.todoapplication.ui.viewmodel.TodoDetailViewModel

class TodoDetailFragment : Fragment() {
    private lateinit var binding: FragmentTodoDetailBinding
    private lateinit var viewModel: TodoDetailViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTodoDetailBinding.inflate(inflater, container, false)

        val bundle: TodoDetailFragmentArgs by navArgs()
        val inboundTodo = bundle.todo

        binding.editTextTodoName.setText(inboundTodo.todo_name)

        binding.buttonUpdate.setOnClickListener {
            val todo_name = binding.editTextTodoName.text.toString()
            viewModel.update(inboundTodo.todo_id, todo_name)
        }
        return binding.root
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: TodoDetailViewModel by viewModels()
        viewModel = tempViewModel
    }
}