package dev.iquick.brainrotsoundboard.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dev.iquick.brainrotsoundboard.R

data class SoundItem(
    val name: String,
    val imageResId: Int,
    val soundResId: Int
)

class SoundboardAdapter(
    private val soundList: List<SoundItem>,
    private val onItemClicked: (SoundItem) -> Unit // Lambda for click handling
) : RecyclerView.Adapter<SoundboardAdapter.SoundViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SoundViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_sound_button, parent, false)
        return SoundViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: SoundViewHolder, position: Int) {
        val currentItem = soundList[position]
        holder.soundName.text = currentItem.name
        holder.soundImage.setImageResource(currentItem.imageResId)

        holder.itemView.setOnClickListener {
            onItemClicked(currentItem) // Call the lambda passed from the Fragment
        }
    }

    override fun getItemCount() = soundList.size

    class SoundViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val soundImage: ImageView = itemView.findViewById(R.id.sound_image_view)
        val soundName: TextView = itemView.findViewById(R.id.sound_name_text_view)
    }
}
