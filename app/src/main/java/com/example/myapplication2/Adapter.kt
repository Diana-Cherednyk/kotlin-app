package com.example.myapplication2

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions


class Adapter(val activity: Activity): RecyclerView.Adapter<Adapter.ViewHolder>() {
    private var listText = arrayListOf<Model>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.nav_list, parent, false))
    }

    override fun getItemCount(): Int {
        return listText.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listText[position])
    }

    fun setData(courseItems: List<Model>) {
        listText.clear()
        listText.addAll(courseItems)
    }

    inner class ViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
        fun bind(textList: Model) {
            with(view) {

                Glide.with(this.context)
                    .load(textList.image)
                    .apply(RequestOptions().override(350, 550))
                    .into(text_image)

                text_name.text = textList.name
                text_information.text = textList.information

                view.btnMore.setOnClickListener {
                    val i = Intent(activity, SecondActivity::class.java)
                    i.putExtra("IMAGE_KEY", textList.image)
                    i.putExtra("NAME_KEY", textList.name)
                    i.putExtra("SUMMARY_KEY", textList.information)
                    activity.startActivity(i)
                }
            }
        }
    }
}