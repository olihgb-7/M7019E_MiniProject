package ltu.m7019e.m7019e_miniproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ltu.m7019e.m7019e_miniproject.databinding.FragmentMonsterDetailBinding
import ltu.m7019e.m7019e_miniproject.databinding.FragmentMonsterSelectionBinding

class MonsterDetailFragment : Fragment() {

    private var _binding: FragmentMonsterDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMonsterDetailBinding.inflate(inflater)

        return binding.root
    }

}