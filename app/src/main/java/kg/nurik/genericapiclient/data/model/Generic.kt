package kg.nurik.genericapiclient.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Generic(
    val id: Int,
    val type: String,
    val setup: String,
    val punchline: String
) : Parcelable