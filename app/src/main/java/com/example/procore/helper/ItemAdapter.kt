package com.example.procore.helper

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.procore.R
import com.example.procore.home.HomeFragmentDirections
import com.example.procore.network.json.Pokemon
import com.squareup.picasso.Picasso

class ItemAdapter(private val dataSet: List<Pokemon>) :
    RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder)
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val pokemonCardView: ImageView = view.findViewById(R.id.pokemon_card)
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.pokemon_card, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        val pokemonCard = dataSet[position]


        pokemonCard.images?.small?.let { url ->
            Picasso.get()
                .load(url)
                .into(viewHolder.pokemonCardView);
        }

        viewHolder.pokemonCardView.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToDetailsFragment(pokemonCard)
            it.findNavController().navigate(action)
        }

    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}