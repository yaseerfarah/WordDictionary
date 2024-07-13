package com.yasser.common.presentation.extensions

import android.net.Uri
import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.Json

fun <T> encodeCustomObjectToUriSafeString(serializer: KSerializer<T>, value: T): String {
    val jsonString = Json.encodeToString(serializer, value)
    return Uri.encode(jsonString)
}

fun <T> decodeCustomObjectFromUriSafe(serializer: KSerializer<T>, encodedString: String): T {
    val decodedString = Uri.decode(encodedString)
    return Json.decodeFromString(serializer, decodedString)
}

