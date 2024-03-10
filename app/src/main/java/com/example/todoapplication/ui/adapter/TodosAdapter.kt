package com.example.todoapplication.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapplication.data.entity.Todos
import com.example.todoapplication.databinding.CardDesignBinding
import com.example.todoapplication.ui.fragment.HomepageFragmentDirections
import com.example.todoapplication.ui.viewmodel.HomepageViewModel
import com.example.todoapplication.utils.migration
import com.google.android.material.snackbar.Snackbar

class TodosAdapter(private var mContext: Context,
                   private var todosList: List<Todos>,
                   private var viewModel:HomepageViewModel)
    : RecyclerView.Adapter<TodosAdapter.CardDesignHolder>() {
    inner class CardDesignHolder(var design: CardDesignBinding): RecyclerView.ViewHolder(design.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHolder {
        val binding = CardDesignBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return CardDesignHolder(binding)
    }

    override fun onBindViewHolder(holder: CardDesignHolder, position: Int) {
        val todo = todosList[position]
        val t = holder.design
        t.textViewTodoName.text = todo.name

        t.cardViewRow.setOnClickListener {
            val migration = HomepageFragmentDirections.todoDetailMigration(todo = todo)
            Navigation.migration(it,migration)
        }

        t.imageViewDelete.setOnClickListener {
            Snackbar.make(it,"Delete ${todo.name} ?", Snackbar.LENGTH_SHORT)
                .setAction("YES"){
                    viewModel.delete(todo.id)
                }.show()
        }
    }

    override fun getItemCount(): Int {
        return todosList.size
    }


}