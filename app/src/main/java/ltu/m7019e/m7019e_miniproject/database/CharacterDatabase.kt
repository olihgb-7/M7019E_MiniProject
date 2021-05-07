package ltu.m7019e.m7019e_miniproject.database


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ltu.m7019e.m7019e_miniproject.model.Character

@Database(entities = [Character::class], version = 1, exportSchema = false)
abstract class CharacterDatabase : RoomDatabase() {
    abstract val characterDatabaseDao: CharacterDatabaseDao

    companion object {

        @Volatile
        private var INSTANCE: CharacterDatabase? = null

        fun getInstance(context: Context): CharacterDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        CharacterDatabase::class.java,
                        "saved_movie_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}