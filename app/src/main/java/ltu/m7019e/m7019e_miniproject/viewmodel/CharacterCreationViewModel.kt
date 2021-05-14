package ltu.m7019e.m7019e_miniproject.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ltu.m7019e.m7019e_miniproject.database.CharacterDatabaseDao
import ltu.m7019e.m7019e_miniproject.model.Character
import java.lang.IllegalArgumentException

class CharacterCreationViewModel(private val characterDatabaseDao: CharacterDatabaseDao, application: Application) : AndroidViewModel(application) {

    init {

    }

    fun saveCharacter(character: Character) {
        viewModelScope.launch {
            characterDatabaseDao.insert(character)
        }
    }

    class Factory (private val characterDatabaseDao: CharacterDatabaseDao, private val application: Application): ViewModelProvider.Factory {

        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(CharacterCreationViewModel::class.java)) {
                return CharacterCreationViewModel(characterDatabaseDao, application) as T
            }
            throw IllegalArgumentException("Unkown ViewModel class")
        }
    }
}