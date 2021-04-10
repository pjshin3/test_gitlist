package com.example.mytest.domain

interface BaseUseCase <in Request, out Result>{
    suspend operator fun invoke(pram: Request): Result
}