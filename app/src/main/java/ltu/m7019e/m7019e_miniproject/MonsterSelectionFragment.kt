package ltu.m7019e.m7019e_miniproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import ltu.m7019e.m7019e_miniproject.adapter.MonsterSelectionAdapter
import ltu.m7019e.m7019e_miniproject.databinding.FragmentMonsterSelectionBinding
import ltu.m7019e.m7019e_miniproject.viewmodel.MonsterSelectionViewModel
import ltu.m7019e.m7019e_miniproject.viewmodel.MonsterSelectionViewModelFactory

class MonsterSelectionFragment : Fragment() {

    private var _binding: FragmentMonsterSelectionBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: MonsterSelectionViewModel
    private lateinit var viewModelFactory: MonsterSelectionViewModelFactory

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMonsterSelectionBinding.inflate(inflater)

        val application = requireNotNull(this.activity).application

        viewModelFactory = MonsterSelectionViewModelFactory(application)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MonsterSelectionViewModel::class.java)

        val monsterSelectionAdapter = MonsterSelectionAdapter()
        binding.monsterSelectionRv.adapter = monsterSelectionAdapter
        viewModel.monsterList.observe(viewLifecycleOwner, { monsterList ->
            monsterList?.let {
                monsterSelectionAdapter.submitList(monsterList)
            }
        })

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.monsterSelectionBack.setOnClickListener {
            findNavController().navigate(MonsterSelectionFragmentDirections.actionMonsterSelectionFragmentToHomepageFragment())
        }
    }
}