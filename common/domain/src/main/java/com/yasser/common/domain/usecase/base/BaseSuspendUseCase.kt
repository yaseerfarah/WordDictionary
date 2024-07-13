package com.yasser.common.domain.usecase.base

interface BaseSuspendUseCase<INPUT,OUTPUT> {
    suspend operator fun invoke(input: INPUT): OUTPUT
}