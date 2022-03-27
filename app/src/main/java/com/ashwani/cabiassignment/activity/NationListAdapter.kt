package com.ashwani.cabiassignment.activity

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.ashwani.cabiassignment.R
import com.ashwani.cabiassignment.model.Nation

class NationListAdapter(nationList: List<Nation>) : RecyclerView.Adapter<NationListAdapter.ViewHolder>() {
    var nationList = nationList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.getContext())
        val listItem: View = layoutInflater.inflate(R.layout.list_item_view, parent, false)
        return ViewHolder(listItem)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val nation: Nation = nationList.get(position)
        holder.nationNameTextView.setText(nation.Nation)
        holder.nationPopulationTextView.setText(nation.Population)
        holder.nationYearTextView.setText(nation.ID_Year)

        holder.nationNameTextView.setOnClickListener(View.OnClickListener { view ->
            Toast.makeText(
                view.context,
                "click on item: " + nation.Slug_Nation,
                Toast.LENGTH_LONG
            ).show()
        })
    }

    override fun getItemId(position: Int): Long {
        return super.getItemId(position)
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }
    override fun getItemCount(): Int {
        return nationList.size
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var nationNameTextView: TextView
        var nationPopulationTextView: TextView
        var nationYearTextView: TextView

        init {
            nationNameTextView = itemView.findViewById(R.id.nationNameTextView) as TextView
            nationPopulationTextView = itemView.findViewById(R.id.nationPopulationTextView) as TextView
            nationYearTextView = itemView.findViewById(R.id.nationYearTextView) as TextView
        }
    }
}