package com.example.odev7todoapp.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.odev7todoapp.data.entity.Todo
import com.example.odev7todoapp.databinding.CardDesignBinding
import com.example.odev7todoapp.ui.fragments.MainPageFragment
import com.example.odev7todoapp.ui.fragments.MainPageFragmentDirections
import com.example.odev7todoapp.ui.viewmodel.MainPageViewModel
import com.example.odev7todoapp.utils.doNavigate
import com.google.android.material.snackbar.Snackbar

class TodoAdapter(var mContext: Context,
                  var todoList: List<Todo>,
                  var viewModel: MainPageViewModel)
    : RecyclerView.Adapter<TodoAdapter.CardDesignHolder>(){

    inner class CardDesignHolder(var design: CardDesignBinding) : RecyclerView.ViewHolder(design.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CardDesignHolder {

        val layoutInflater = LayoutInflater.from(mContext)
        val design = CardDesignBinding.inflate(layoutInflater, parent, false)
        return CardDesignHolder(design)
    }

    override fun onBindViewHolder(
        holder: CardDesignHolder,
        position: Int
    ) {
        val todo = todoList.get(position) // loop over todos and list them iteratively on recycler view
        val t = holder.design
        t.textViewTodoId.text = todo.id.toString()
        t.textViewTodoName.text = todo.name
        t.textViewTodoStartAndEnd.text = "${todo.startDate} - ${todo.endDate}"

        t.cardViewRow.setOnClickListener {
            val gecis = MainPageFragmentDirections.detayGecis(todo = todo)
//            Navigation.findNavController(it).navigate(gecis) eski kod
            Navigation.doNavigate(it, gecis)
            Log.e("Detay Geçiş", "${todo.name} kartı detay sayfasına gönderildi")
        }

        t.imageViewDelete.setOnClickListener {
            Snackbar.make(it, "${todo.name} kartı silinsin mi?", Snackbar.LENGTH_SHORT)
                .setAction("EVET") {
                    Log.e("Todo Sil", todo.id.toString())
                }.show()
        }
    }

    override fun getItemCount(): Int {
        return todoList.size
    }
}
