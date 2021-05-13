package ltu.m7019e.m7019e_miniproject.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ltu.m7019e.m7019e_miniproject.database.CharacterDatabaseDao
import ltu.m7019e.m7019e_miniproject.model.Character

class CharacterDetailViewModel(private val characterDatabaseDao: CharacterDatabaseDao, application: Application) : AndroidViewModel(application) {

    init {

    }

    fun deleteCharacter(character: Character) {
        viewModelScope.launch {
            characterDatabaseDao.delete(character)
        }
    }

}