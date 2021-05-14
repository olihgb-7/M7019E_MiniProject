package ltu.m7019e.m7019e_miniproject

import android.content.pm.ActivityInfo
import android.content.res.Configuration
import android.hardware.SensorManager
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.OrientationEventListener
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import ltu.m7019e.m7019e_miniproject.databinding.FragmentPlayersHandbookBinding
import ltu.m7019e.m7019e_miniproject.network.DataFetchStatus
import ltu.m7019e.m7019e_miniproject.utils.Constants
import ltu.m7019e.m7019e_miniproject.viewmodel.MonsterSelectionViewModel
import ltu.m7019e.m7019e_miniproject.viewmodel.PlayersHandbookViewModel

class PlayersHandbookFragment : Fragment() {

    private var _binding: FragmentPlayersHandbookBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: PlayersHandbookViewModel
    private lateinit var viewModelFactory: PlayersHandbookViewModel.Factory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentPlayersHandbookBinding.inflate(inflater)
        requireActivity().requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED

        val application = requireNotNull(this.activity).application
        viewModelFactory = PlayersHandbookViewModel.Factory(application)
        viewModel = ViewModelProvider(this, viewModelFactory).get(PlayersHandbookViewModel::class.java)

        viewModel.setupWebView(binding)

        if(resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE){
            binding.playersHandbookWv.visibility = View.VISIBLE
            binding.playersHandbookInstructions.visibility = View.GONE
            binding.playersHanbookRotate.visibility = View.GONE
            binding.playersHandbookBack.visibility = View.GONE
            activity?.window?.decorView?.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

            viewModel.dataFetchStatus.observe(viewLifecycleOwner,{ status ->
                when(status) {
                    DataFetchStatus.LOADING -> {
                        binding.playersHandbookProgressBar.visibility = View.VISIBLE
                    }
                    DataFetchStatus.ERROR -> {
                        binding.playersHandbookProgressBar.visibility = View.GONE
                        binding.playersHanbookStatus.visibility = View.VISIBLE
                        binding.playersHanbookStatus.setImageResource(R.drawable.ic_connection_error)
                    }
                    DataFetchStatus.DONE -> {
                        binding.playersHandbookProgressBar.visibility = View.GONE
                        binding.playersHanbookStatus.visibility = View.GONE
                    }
                }
            })
        }
        else {
            binding.playersHandbookWv.visibility = View.GONE
            binding.playersHandbookProgressBar.visibility = View.GONE
            binding.playersHandbookInstructions.visibility = View.VISIBLE
            binding.playersHanbookRotate.visibility = View.VISIBLE
            binding.playersHandbookBack.visibility = View.VISIBLE
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.playersHandbookBack.setOnClickListener {
            findNavController().navigate(PlayersHandbookFragmentDirections.actionPlayersHandbookFragmentToHomepageFragment())
        }
    }


}