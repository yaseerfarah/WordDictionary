package com.yasser.common.domain.usecase.base

interface BaseUseCase<INPUT,OUTPUT> {
    operator fun invoke(input: INPUT): OUTPUT
}