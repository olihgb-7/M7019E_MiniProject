package ltu.m7019e.m7019e_miniproject.viewmodel

import android.app.Application
import androidx.lifecycle.*
import kotlinx.coroutines.launch
import ltu.m7019e.m7019e_miniproject.databinding.FragmentMonsterDetailBinding
import ltu.m7019e.m7019e_miniproject.network.MonsterDetailsResponse
import java.lang.Exception
import java.lang.IllegalArgumentException

class MonsterDetailViewModel(monsterIndex: String, application: Application) : AndroidViewModel(application) {

    private var monsterIndex = monsterIndex

    init {}

    fun getMonsterDetails(binding: FragmentMonsterDetailBinding) {
        viewModelScope.launch {
            try {
                val monsterDetailsResponse: MonsterDetailsResponse = DnDApi.monsterListRetrofitService.getMonsterDetails("monsters/$monsterIndex")

                binding.monsterDetailName.text = monsterDetailsResponse.name
                binding.monsterDetailSize.text = monsterDetailsResponse.size
                binding.monsterDetailType.text = monsterDetailsResponse.type + ","
                binding.monsterDetailAlignment.text = monsterDetailsResponse.alignment

                binding.monsterDetailStrength.text = monsterDetailsResponse.strength
                binding.monsterrDetailDexterity.text = monsterDetailsResponse.dexterity
                binding.monsterDetailConstitution.text = monsterDetailsResponse.constitution
                binding.monsterDetailIntelligence.text = monsterDetailsResponse.intelligence
                binding.monsterDetailWisdom.text = monsterDetailsResponse.wisdom
                binding.monsterDetailCharisma.text = monsterDetailsResponse.charisma

                binding.monsterDetailHealtPoints.text = monsterDetailsResponse.hitPoints
                binding.monsterDetailSpeed.text = monsterDetailsResponse.speed.walk
                binding.monsterDetailArmourClass.text = monsterDetailsResponse.armorClass
            }
            catch (e: Exception) {

            }
        }
    }

    class Factory(private val monsterIndex: String, private val application: Application): ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(MonsterDetailViewModel::class.java)) {
                return MonsterDetailViewModel(monsterIndex, application) as T
            }
            throw IllegalArgumentException("Unkown ViewModel class")
        }
    }
}