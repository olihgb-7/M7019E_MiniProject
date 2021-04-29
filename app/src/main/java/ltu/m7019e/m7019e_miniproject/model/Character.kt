package ltu.m7019e.m7019e_miniproject.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "characters")
data class Character (
        @PrimaryKey(autoGenerate = true)
        var id: Long = 0L,

        @ColumnInfo(name = "name")
        var name: String,

        @ColumnInfo(name = "dnd_class")
        var dndClass: String,

        @ColumnInfo(name = "race")
        var race: String,

        @ColumnInfo(name = "strength")
        var strength: Int,

        @ColumnInfo(name = "dexterity")
        var dexterity: Int,

        @ColumnInfo(name = "constitution")
        var constitution: Int,

        @ColumnInfo(name = "intelligence")
        var intelligence: Int,

        @ColumnInfo(name = "wisdom")
        var wisdom: Int,

        @ColumnInfo(name = "charisma")
        var charisma: Int,

        @ColumnInfo(name = "health_points")
        var healthPoints: Int,

        @ColumnInfo(name = "armour_class")
        var armourClass: Int,

        @ColumnInfo(name = "initiative")
        var initiative: Int,

        @ColumnInfo(name = "speed")
        var speed: Int
): Parcelable