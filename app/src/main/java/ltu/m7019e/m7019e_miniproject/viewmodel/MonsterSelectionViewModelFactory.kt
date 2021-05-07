package ltu.m7019e.m7019e_miniproject.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class MonsterSelectionViewModelFactory(private val application: Application): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MonsterSelectionViewModel::class.java)) {
            return MonsterSelectionViewModel(application) as T
        }
        throw IllegalArgumentException("Unkown ViewModel class")
    }
}