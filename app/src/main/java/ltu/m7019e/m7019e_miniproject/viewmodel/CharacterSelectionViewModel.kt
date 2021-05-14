package ltu.m7019e.m7019e_miniproject.viewmodel

import android.app.Application
import androidx.lifecycle.*
import kotlinx.coroutines.launch
import ltu.m7019e.m7019e_miniproject.database.CharacterDatabaseDao
import ltu.m7019e.m7019e_miniproject.model.Character
import java.lang.IllegalArgumentException

class CharacterSelectionViewModel(private val characterDatabaseDao: CharacterDatabaseDao, application: Application) : AndroidViewModel(application) {

    private val _characterList = MutableLiveData<List<Character>>()
    val characterList: LiveData<List<Character>>
        get() {
            return _characterList
        }

    private val _navigateToCharacterDetail = MutableLiveData<Character>()
    val navigateToCharacterDetail: LiveData<Character>
        get() {
            return _navigateToCharacterDetail
        }

    init {
        getCharacters()
    }

    fun getCharacters() {
        viewModelScope.launch {
            _characterList.value = characterDatabaseDao.getAllCharacters()
        }
    }

    fun onCharacterItemClicked(character: Character) {
        _navigateToCharacterDetail.value = character
    }

    fun onCharacterDetailNavigated() {
        _navigateToCharacterDetail.value = null
    }

    class Factory(private val characterDatabaseDao: CharacterDatabaseDao, private val application: Application): ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(CharacterSelectionViewModel::class.java)) {
                return CharacterSelectionViewModel(characterDatabaseDao, application) as T
            }
            throw IllegalArgumentException("Unkown ViewModel class")
        }
    }
}