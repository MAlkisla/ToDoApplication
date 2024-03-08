package com.example.todoapplication.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.todoapplication.databinding.FragmentTodoDetailBinding

class TodoDetailFragment : Fragment() {
    private lateinit var binding: FragmentTodoDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTodoDetailBinding.inflate(inflater, container, false)

        val bundle:TodoDetailFragmentArgs by navArgs()
        val inboundTodo = bundle.todo

        binding.editTextTodoName.setText(inboundTodo.todo_name)

        binding.buttonUpdate.setOnClickListener {
            val todo_name= binding.editTextTodoName.text.toString()
            update(inboundTodo.todo_id,todo_name)
        }
        return binding.root
    }

    private fun update(todo_id:Int, todo_name:String){
        Log.e("To-Do Update","$todo_id - $todo_name")
    }
}