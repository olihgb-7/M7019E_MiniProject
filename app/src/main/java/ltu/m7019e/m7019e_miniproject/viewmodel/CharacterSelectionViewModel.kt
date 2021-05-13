package ltu.m7019e.m7019e_miniproject.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ltu.m7019e.m7019e_miniproject.database.CharacterDatabaseDao
import ltu.m7019e.m7019e_miniproject.model.Character

class CharacterSelectionViewModel(private val characterDatabaseDao: CharacterDatabaseDao, application: Application) : AndroidViewModel(application) {

    private val _characterList = MutableLiveData<List<Character>>()
    val characterList: LiveData<List<Character>>
        get() {
            return _characterList
        }

    init {
        getCharacters()
    }

    fun getCharacters() {
        viewModelScope.launch {
            _characterList.value = characterDatabaseDao.getAllCharacters()
        }
    }
}