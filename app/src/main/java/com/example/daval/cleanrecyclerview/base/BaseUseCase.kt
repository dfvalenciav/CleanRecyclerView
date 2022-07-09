package com.example.daval.cleanrecyclerview.base

abstract class BaseUseCase<T> {
    abstract suspend fun execute(): List<T>
}