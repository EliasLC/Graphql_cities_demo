package com.example.demo.services

import com.example.demo.entities.City
import com.example.demo.entities.Ranch
import com.example.demo.repositories.RanchRepository
import org.springframework.stereotype.Service

@Service
class RanchService(val ranchRepository: RanchRepository) : ApiService<Ranch> {

    override fun getAll(): List<Ranch> {
        return ranchRepository.findAll()
    }

    override fun getByName(name: String): List<Ranch> {
        return ranchRepository.findByName(name)
    }

    fun getCity (ranchId: String) : City {
        val ranch = ranchRepository.findById(ranchId).get()

        return ranch.city!!
    }

}