package com.example.demo.services

import com.example.demo.entities.City
import com.example.demo.entities.Municipality
import com.example.demo.repositories.CityRepository
import com.example.demo.repositories.MunicipalityRepository
import org.springframework.stereotype.Service

@Service
class MunicipalityService(
    val municipalityRepository: MunicipalityRepository,
    val cityRepository: CityRepository
    ) : ApiService<Municipality> {

    override fun getAll(): List<Municipality> {
        return municipalityRepository.findAll()
    }

    override fun getByName(name: String): List<Municipality> {
        return municipalityRepository.findByName(name)
    }

    fun getCity(id: String) : City {
        val municipality = this.municipalityRepository.findById(id).get()

        return municipality.city!!
    }
}