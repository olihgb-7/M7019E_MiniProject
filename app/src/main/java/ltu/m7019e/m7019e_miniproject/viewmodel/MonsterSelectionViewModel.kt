package ltu.m7019e.m7019e_miniproject.viewmodel

import DnDApi
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ltu.m7019e.m7019e_miniproject.model.Character
import ltu.m7019e.m7019e_miniproject.model.Monster
import ltu.m7019e.m7019e_miniproject.network.MonstersResponse

class MonsterSelectionViewModel(application: Application) : AndroidViewModel(application) {

    private val _monsterList = MutableLiveData<List<Monster>>()
    val monsterList: LiveData<List<Monster>>
        get() {
            return _monsterList
        }

    init {
        getMonsters()
    }

    fun getMonsters() {
        viewModelScope.launch {
            val monstersResponse: MonstersResponse = DnDApi.monsterListRetrofitService.getMonsters()
            _monsterList.value = monstersResponse.results
        }
    }
}