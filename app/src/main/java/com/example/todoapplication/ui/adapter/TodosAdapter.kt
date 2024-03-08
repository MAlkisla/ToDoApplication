package com.example.todoapplication.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapplication.data.entity.Todos
import com.example.todoapplication.databinding.CardDesignBinding
import com.example.todoapplication.ui.fragment.HomepageFragmentDirections
import com.google.android.material.snackbar.Snackbar

class TodosAdapter(private var mContext: Context, private var todosList: List<Todos>)
    : RecyclerView.Adapter<TodosAdapter.CardDesignHolder>() {
    inner class CardDesignHolder(var design: CardDesignBinding): RecyclerView.ViewHolder(design.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHolder {
        val binding = CardDesignBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return CardDesignHolder(binding)
    }

    override fun onBindViewHolder(holder: CardDesignHolder, position: Int) {
        val todo = todosList[position]
        val t = holder.design
        t.textViewTodoName.text = todo.todo_name

        t.cardViewRow.setOnClickListener {
            val migration = HomepageFragmentDirections.todoDetailMigration(todo = todo)
            Navigation.findNavController(it).navigate(migration)
        }

        t.imageViewDelete.setOnClickListener {
            Snackbar.make(it,"Delete ${todo.todo_name} ?", Snackbar.LENGTH_SHORT)
                .setAction("YES"){
                    delete(todo.todo_id)
                }.show()
        }
    }

    override fun getItemCount(): Int {
        return todosList.size
    }

    private fun delete(todo_id:Int){
        Log.e("To-Do Delete", todo_id.toString())
    }

}