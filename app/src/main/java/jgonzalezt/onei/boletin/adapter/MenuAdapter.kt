package jgonzalezt.onei.boletin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.findFragment
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.RecyclerView
import jgonzalezt.onei.boletin.R
import jgonzalezt.onei.boletin.model.Menu

class MenuAdapter(
    private val context: Context,
    private val dataset: List<Menu>
) : RecyclerView.Adapter<MenuAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.item_image)
        val textView: TextView = view.findViewById(R.id.item_title)

        init {
            imageView.setOnClickListener {
                when (adapterPosition) {
                    0 -> {
                        NavHostFragment.findNavController(view.findFragment())
                            .navigate(R.id.action_menuFragment_to_oneiFragment)
                    }
                    1 -> {
                        NavHostFragment.findNavController(view.findFragment())
                            .navigate(R.id.action_menuFragment_to_holguinFragment)
                    }
                    2 -> {
                        NavHostFragment.findNavController(view.findFragment())
                            .navigate(R.id.action_menuFragment_to_leyDecFragment)
                    }
                    3 -> {
                        NavHostFragment.findNavController(view.findFragment())
                            .navigate(R.id.action_menuFragment_to_demografiaFragment)
                    }
                    4 -> {
                        NavHostFragment.findNavController(view.findFragment())
                            .navigate(R.id.action_menuFragment_to_contactFragment)
                    }
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // create a new view
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_menu, parent, false)

        return ViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataset[position]
        holder.imageView.setImageResource(item.imageResourceId)
        holder.textView.text = context.resources.getString(item.stringResourceId)
    }

    override fun getItemCount() = dataset.size
}