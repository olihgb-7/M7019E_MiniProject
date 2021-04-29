package ltu.m7019e.m7019e_miniproject.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import ltu.m7019e.m7019e_miniproject.model.Character

@Dao
interface CharacterDatabaseDao {
    @Insert
    suspend fun insert(character: Character)

    @Delete
    suspend fun delete(character: Character)

    @Query("SELECT * from characters ORDER BY id ASC")
    suspend fun getAllCharacters(): List<Character>
}