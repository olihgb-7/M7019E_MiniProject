package ltu.m7019e.m7019e_miniproject

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
import androidx.navigation.fragment.findNavController
import ltu.m7019e.m7019e_miniproject.databinding.FragmentPlayersHandbookBinding
import ltu.m7019e.m7019e_miniproject.utils.Constants

class PlayersHandbookFragment : Fragment() {

    private var _binding: FragmentPlayersHandbookBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentPlayersHandbookBinding.inflate(inflater)

        binding.playersHandbookWv.settings.javaScriptEnabled = true
        binding.playersHandbookWv.settings.pluginState = WebSettings.PluginState.ON
        binding.playersHandbookWv.loadUrl(Constants.PLAYERS_HANDBOOK_TOYTUBE_URL)
        binding.playersHandbookWv.webChromeClient = WebChromeClient()

        if(resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE){
            binding.playersHandbookWv.visibility = View.VISIBLE
            binding.playersHandbookLabel.visibility = View.GONE
            binding.playersHandbookInstructions.visibility = View.GONE
            binding.playersHanbookRotate.visibility = View.GONE
            binding.playersHandbookBack.visibility = View.GONE
            activity?.window?.decorView?.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        }
        else {
            binding.playersHandbookWv.visibility = View.GONE
            binding.playersHandbookLabel.visibility = View.VISIBLE
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