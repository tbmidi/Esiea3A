package com.example.esiea3a.presentation.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.esiea3a.R


class PokemonAdapter(private var dataSet: List<Pokemon>, var listener: ((Int) -> Unit)? = null) : RecyclerView.Adapter<PokemonAdapter.ViewHolder>() {


    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView
        val imageView: ImageView

        init {
            textView = view.findViewById(R.id.pokemon_name)
            imageView = view.findViewById(R.id.pokemon_img)
        }
    }

    fun updateList(list: List<Pokemon>){
        dataSet = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.pokemon_item, viewGroup, false)

        return ViewHolder(view)
    }


    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        val pokemon = dataSet[position]
        viewHolder.textView.text = pokemon.name
        viewHolder.itemView.setOnClickListener{
            listener?.invoke(position)
        }

        Glide
            .with(viewHolder.itemView.context)
            .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${position + 1}.png")
            .centerCrop()
            .into(viewHolder.imageView)
    }


    override fun getItemCount() = dataSet.size
    fun updateList(list: Unit) {
        TODO("Not yet implemented")
    }

}