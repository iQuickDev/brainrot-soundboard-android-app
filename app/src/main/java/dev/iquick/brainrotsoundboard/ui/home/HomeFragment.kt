package dev.iquick.brainrotsoundboard.ui.home

import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
// Import R class if not automatically imported
import dev.iquick.brainrotsoundboard.R
import dev.iquick.brainrotsoundboard.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var soundboardAdapter: SoundboardAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val soundList = listOf(
            SoundItem("Tralalero Tralalala", R.drawable.tralalerotralala, R.raw.tralalalerotralala),
            SoundItem("Lirili Larila", R.drawable.lirililarila, R.raw.lirililarila),
            SoundItem(
                "Glorbo Fruttodrillo",
                R.drawable.glorbofruttodrillo,
                R.raw.glorbofruttodrillo
            ),
            SoundItem(
                "Ballerina Cappuccina",
                R.drawable.ballerinacappuccina,
                R.raw.ballerinacappuccina
            ),
            SoundItem(
                "Cappuccino Assassino",
                R.drawable.cappuccinoassassino,
                R.raw.cappuccinoassassino
            ),
            SoundItem(
                "Shimpanzini Bananini",
                R.drawable.chimpanzinibananini,
                R.raw.chimpanzinibananini
            ),
            SoundItem(
                "Tung Tung Tung Tung Tung Sahur",
                R.drawable.tungtungtungtungtungsahur,
                R.raw.tungtungtungtungtungsahur
            ),
        )

        soundboardAdapter = SoundboardAdapter(soundList) { soundItem ->
            val mp = MediaPlayer.create(requireContext(), soundItem.soundResId)
            mp.setOnCompletionListener {
                it.release()
            }
            mp.start()
        }

        binding.soundboardRecyclerView.apply {
            layoutManager = GridLayoutManager(context, 3)
            adapter = soundboardAdapter
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
