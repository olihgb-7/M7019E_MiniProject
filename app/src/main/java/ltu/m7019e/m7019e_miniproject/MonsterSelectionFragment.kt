package ltu.m7019e.m7019e_miniproject

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import ltu.m7019e.m7019e_miniproject.adapter.CharacterClickListener
import ltu.m7019e.m7019e_miniproject.adapter.MonsterClickListener
import ltu.m7019e.m7019e_miniproject.adapter.MonsterSelectionAdapter
import ltu.m7019e.m7019e_miniproject.databinding.FragmentMonsterSelectionBinding
import ltu.m7019e.m7019e_miniproject.network.DataFetchStatus
import ltu.m7019e.m7019e_miniproject.viewmodel.MonsterSelectionViewModel

class MonsterSelectionFragment : Fragment() {

    private var _binding: FragmentMonsterSelectionBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: MonsterSelectionViewModel
    private lateinit var viewModelFactory: MonsterSelectionViewModel.Factory

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMonsterSelectionBinding.inflate(inflater)
        requireActivity().requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED

        val application = requireNotNull(this.activity).application
        viewModelFactory = MonsterSelectionViewModel.Factory(application)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MonsterSelectionViewModel::class.java)

        val monsterSelectionAdapter = MonsterSelectionAdapter(
            MonsterClickListener { monster ->
                viewModel.onMonsterItemClicked(monster)
            }
        )
        binding.monsterSelectionRv.adapter = monsterSelectionAdapter
        viewModel.monsterList.observe(viewLifecycleOwner, { monsterList ->
            monsterList?.let {
                monsterSelectionAdapter.submitList(monsterList)
            }
        })

        viewModel.navigateToMonsterDetail.observe(viewLifecycleOwner, { monster ->
            monster?.let {
                Log.i("CLICKED", "CLICKED")
                this.findNavController().navigate(
                    MonsterSelectionFragmentDirections.actionMonsterSelectionFragmentToMonsterDetailFragment(monster)
                )
                viewModel.onMonsterDetailNavigated()
            }
        })

        viewModel.dataFetchStatus.observe(viewLifecycleOwner,{ status ->
            when(status) {
                DataFetchStatus.LOADING -> {
                    binding.monsterSelectionProgressBar.visibility = View.VISIBLE
                }
                DataFetchStatus.ERROR -> {
                    binding.monsterSelectionProgressBar.visibility = View.GONE
                    binding.monsterSelectionStatus.visibility = View.VISIBLE
                    binding.monsterSelectionStatus.setImageResource(R.drawable.ic_connection_error)
                }
                DataFetchStatus.DONE -> {
                    binding.monsterSelectionStatus.visibility = View.GONE
                    binding.monsterSelectionProgressBar.visibility = View.GONE
                }
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