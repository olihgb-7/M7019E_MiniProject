package ltu.m7019e.m7019e_miniproject.viewmodel

import android.app.Application
import androidx.lifecycle.*
import kotlinx.coroutines.launch
import ltu.m7019e.m7019e_miniproject.database.CharacterDatabaseDao
import ltu.m7019e.m7019e_miniproject.model.Character
import ltu.m7019e.m7019e_miniproject.model.Monster
import ltu.m7019e.m7019e_miniproject.network.CharacterRaceResponse
import ltu.m7019e.m7019e_miniproject.network.DataFetchStatus
import ltu.m7019e.m7019e_miniproject.network.MonstersResponse
import java.lang.Exception
import java.lang.IllegalArgumentException

class CharacterCreationViewModel(private val characterDatabaseDao: CharacterDatabaseDao, application: Application) : AndroidViewModel(application) {

    private val _alignmentDescription = MutableLiveData<String>()
    val alignmentDescription: LiveData<String>
        get() {
            return _alignmentDescription
        }

    private val _ageDescription = MutableLiveData<String>()
    val ageDescription: LiveData<String>
        get() {
            return _ageDescription
        }

    private val _sizeDescription = MutableLiveData<String>()
    val sizeDescription: LiveData<String>
        get() {
            return _sizeDescription
        }

    init {

    }

    fun saveCharacter(character: Character) {
        viewModelScope.launch {
            characterDatabaseDao.insert(character)
        }
    }

    fun getCharacterRaceAlignment(raceIndex: String) {
        viewModelScope.launch {
            try {
                val characterRaceResponse: CharacterRaceResponse = DnDApi.monsterListRetrofitService.getCharacterRace("races/$raceIndex")
                _alignmentDescription.value = characterRaceResponse.alignment
                _ageDescription.value = characterRaceResponse.age
                _sizeDescription.value = characterRaceResponse.sizeDescription
            }
            catch (e: Exception) {
                _alignmentDescription.value = ""
                _ageDescription.value = ""
                _sizeDescription.value = ""

            }
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