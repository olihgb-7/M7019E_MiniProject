package ltu.m7019e.m7019e_miniproject.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ltu.m7019e.m7019e_miniproject.database.CharacterDatabaseDao
import java.lang.IllegalArgumentException

class CharacterSelectionViewModelFactory(
    private val characterDatabaseDao: CharacterDatabaseDao,
    private val application: Application
    ): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CharacterSelectionViewModel::class.java)) {
            return CharacterSelectionViewModel(characterDatabaseDao, application) as T
        }
        throw IllegalArgumentException("Unkown ViewModel class")
    }
}