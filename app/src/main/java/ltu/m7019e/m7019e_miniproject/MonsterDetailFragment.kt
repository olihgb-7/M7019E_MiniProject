package ltu.m7019e.m7019e_miniproject

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import ltu.m7019e.m7019e_miniproject.databinding.FragmentMonsterDetailBinding
import ltu.m7019e.m7019e_miniproject.databinding.FragmentMonsterSelectionBinding
import ltu.m7019e.m7019e_miniproject.model.Monster
import ltu.m7019e.m7019e_miniproject.viewmodel.MonsterDetailViewModel
import ltu.m7019e.m7019e_miniproject.viewmodel.MonsterSelectionViewModel

class MonsterDetailFragment : Fragment() {

    private var _binding: FragmentMonsterDetailBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: MonsterDetailViewModel
    private lateinit var viewModelFactory: MonsterDetailViewModel.Factory

    private lateinit var monster: Monster

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMonsterDetailBinding.inflate(inflater)

        monster = MonsterDetailFragmentArgs.fromBundle(requireArguments()).monster

        val application = requireNotNull(this.activity).application
        viewModelFactory = MonsterDetailViewModel.Factory(monster.index, application)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MonsterDetailViewModel::class.java)

        viewModel.getMonsterDetails(binding)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.monsterDetailBack.setOnClickListener {
            findNavController().navigate(MonsterDetailFragmentDirections.actionMonsterDetailFragmentToMonsterSelectionFragment())
        }
    }
}