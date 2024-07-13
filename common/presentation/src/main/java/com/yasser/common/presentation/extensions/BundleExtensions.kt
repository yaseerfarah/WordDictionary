package com.yasser.common.presentation.extensions

import android.os.Build.VERSION.SDK_INT
import android.os.Bundle
import android.os.Parcelable

fun <T : Parcelable> Bundle.getSafeParcelable(currentClass: Class<T>, key: String): T? = when {
    SDK_INT >= 33 -> getParcelable(key, currentClass)
    else -> @Suppress("DEPRECATION") getParcelable(key) as? T
}