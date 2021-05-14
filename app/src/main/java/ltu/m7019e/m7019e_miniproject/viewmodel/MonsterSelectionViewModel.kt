package ltu.m7019e.m7019e_miniproject.viewmodel

import DnDApi
import android.app.Application
import androidx.lifecycle.*
import kotlinx.coroutines.launch
import ltu.m7019e.m7019e_miniproject.model.Character
import ltu.m7019e.m7019e_miniproject.model.Monster
import ltu.m7019e.m7019e_miniproject.network.DataFetchStatus
import ltu.m7019e.m7019e_miniproject.network.MonstersResponse
import java.lang.Exception
import java.lang.IllegalArgumentException

class MonsterSelectionViewModel(application: Application) : AndroidViewModel(application) {

    private val _monsterList = MutableLiveData<List<Monster>>()
    val monsterList: LiveData<List<Monster>>
        get() {
            return _monsterList
        }

    private val _dataFetchStatus = MutableLiveData<DataFetchStatus>()
    val dataFetchStatus: LiveData<DataFetchStatus>
        get() {
            return _dataFetchStatus
        }

    init {
        getMonsters()
        _dataFetchStatus.value = DataFetchStatus.LOADING
    }

    fun getMonsters() {
        viewModelScope.launch {
            try {
                val monstersResponse: MonstersResponse = DnDApi.monsterListRetrofitService.getMonsters()
                _monsterList.value = monstersResponse.results
                _dataFetchStatus.value = DataFetchStatus.DONE
            }
            catch (e: Exception) {
                _monsterList.value = listOf()
                _dataFetchStatus.value = DataFetchStatus.ERROR
            }
        }
    }

    class Factory(private val application: Application): ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(MonsterSelectionViewModel::class.java)) {
                return MonsterSelectionViewModel(application) as T
            }
            throw IllegalArgumentException("Unkown ViewModel class")
        }
    }
}