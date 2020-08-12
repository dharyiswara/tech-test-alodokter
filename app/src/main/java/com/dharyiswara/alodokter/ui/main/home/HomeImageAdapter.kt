package com.dharyiswara.alodokter.ui.main.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dharyiswara.alodokter.R
import com.dharyiswara.alodokter.helper.loadFromUrl
import com.dharyiswara.alodokter.model.Images
import com.dharyiswara.alodokter.ui.detail.DetailImageActivity
import kotlinx.android.synthetic.main.layout_item_image.view.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class HomeImageAdapter : RecyclerView.Adapter<HomeImageAdapter.HomeImageViewHolder>() {

    private val imageList = mutableListOf<Images>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeImageViewHolder =
        HomeImageViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.layout_item_image, parent, false)
        )

    override fun getItemCount(): Int = imageList.size

    override fun onBindViewHolder(holder: HomeImageViewHolder, position: Int) {
        holder.bind(imageList[position])
    }

    fun replaceData(list: List<Images>) {
        imageList.clear()
        imageList.addAll(list)
        notifyDataSetChanged()
    }

    inner class HomeImageViewHolder(view: View) : RecyclerView.ViewHolder(view) {


        fun bind(image: Images) {
            with(itemView) {
                ivImage.loadFromUrl(image.url)

                llImage.setOnClickListener {
                    context.startActivity<DetailImageActivity>(
                        DetailImageActivity.IMAGES to imageList,
                        DetailImageActivity.INDEX_IMAGES to adapterPosition
                    )
                }
            }
        }

    }

}