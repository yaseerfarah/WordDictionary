package com.yasser.common.domain.entity.network.enums

enum class ExceptionType(val message: String) {
    Network("Check your internet connection, and try again"),
    Empty("Oops, No Data Found"),
    Unknown("Something went wrong, try again later")

}