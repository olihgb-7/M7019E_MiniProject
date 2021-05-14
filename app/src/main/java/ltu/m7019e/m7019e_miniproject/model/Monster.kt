package ltu.m7019e.m7019e_miniproject.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Monster (
    var index: String,
    var name: String,
    var url: String
): Parcelable