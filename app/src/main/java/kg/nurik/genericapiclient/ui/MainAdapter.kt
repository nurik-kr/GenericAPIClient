package kg.nurik.genericapiclient.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kg.nurik.genericapiclient.R
import kg.nurik.genericapiclient.data.model.Generic
import kotlinx.android.synthetic.main.rv_item.view.*

class MainAdapter() : RecyclerView.Adapter<ViewHolder>() {

    private val list = arrayListOf<Generic>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.rv_item, parent, false)
        return ViewHolder(view)
    }

    fun update(list: List<Generic>?) {
        if (list != null) {
            this.list.clear()
            this.list.addAll(list)
            notifyDataSetChanged()
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size
}

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun bind(point: Generic?) {
        itemView.tv_setup.text = point?.setup
        itemView.tv_punchline.text = point?.punchline
    }
}