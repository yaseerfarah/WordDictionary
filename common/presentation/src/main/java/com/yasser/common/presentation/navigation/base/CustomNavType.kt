package com.yasser.common.presentation.navigation.base

import android.net.Uri
import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavType
import com.google.gson.Gson
import com.yasser.common.presentation.extensions.decodeCustomObjectFromUriSafe
import com.yasser.common.presentation.extensions.encodeCustomObjectToUriSafeString
import com.yasser.common.presentation.extensions.getSafeParcelable
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer

class CustomNavType<T>(
    private val currentClass: Class<T>,
    override val isNullableAllowed: Boolean = false
) : NavType<T>(isNullableAllowed) {
    override fun get(bundle: Bundle, key: String): T? =
        Gson().fromJson(bundle.getString(key),currentClass)

    override fun put(bundle: Bundle, key: String, value: T) = bundle.putString(key, Gson().toJson(value))

    override fun parseValue(value: String): T =
        Gson().fromJson(Uri.decode(value),currentClass)

    override fun serializeAsValue(value: T): String =
        Uri.encode(Gson().toJson(value))

    override val name: String = currentClass.simpleName
}