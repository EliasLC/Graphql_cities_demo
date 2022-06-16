package com.example.demo.services

interface ApiService<T> {
    fun getAll() : List<T>

    fun getByName(name: String) : List<T>
}