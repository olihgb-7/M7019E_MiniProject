package ltu.m7019e.m7019e_miniproject.viewmodel

import android.app.Application
import android.view.View
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.lifecycle.*
import ltu.m7019e.m7019e_miniproject.R
import ltu.m7019e.m7019e_miniproject.databinding.FragmentPlayersHandbookBinding
import ltu.m7019e.m7019e_miniproject.network.DataFetchStatus
import ltu.m7019e.m7019e_miniproject.utils.Constants


class PlayersHandbookViewModel(application: Application) : AndroidViewModel(application) {

    private val _dataFetchStatus = MutableLiveData<DataFetchStatus>()
    val dataFetchStatus: LiveData<DataFetchStatus>
        get() {
            return _dataFetchStatus
        }

    init {
        _dataFetchStatus.value = DataFetchStatus.LOADING
    }

    fun setupWebView(binding: FragmentPlayersHandbookBinding) {

        _dataFetchStatus.value = DataFetchStatus.DONE
        binding.playersHandbookWv.settings.javaScriptEnabled = true
        binding.playersHandbookWv.settings.pluginState = WebSettings.PluginState.ON
        binding.playersHandbookWv.loadUrl(Constants.PLAYERS_HANDBOOK_TOYTUBE_URL)
        binding.playersHandbookWv.webViewClient = object : WebViewClient() {
            override fun onReceivedError(view: WebView, errorCode: Int, description: String, failingUrl: String) {
                binding.playersHandbookWv.loadUrl("about:blank")
                _dataFetchStatus.value = DataFetchStatus.ERROR
            }
        }
    }

    class Factory(private val application: Application): ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(PlayersHandbookViewModel::class.java)) {
                return PlayersHandbookViewModel(application) as T
            }
            throw IllegalArgumentException("Unkown ViewModel class")
        }
    }
}