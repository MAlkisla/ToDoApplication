package com.example.todoapplication.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.todoapplication.databinding.FragmentTodoAddBinding

class TodoAddFragment : Fragment() {
    private lateinit var binding: FragmentTodoAddBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTodoAddBinding.inflate(inflater, container, false)

        binding.buttonAdd.setOnClickListener {
            val todo_name = binding.editTextTodoName.text.toString()
            add(todo_name)
        }

        return binding.root
    }

    private fun add(todo_name:String){
        Log.e("To-Do Add", "$todo_name")
    }
}