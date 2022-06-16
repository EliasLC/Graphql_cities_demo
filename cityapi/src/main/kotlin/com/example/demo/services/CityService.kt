package com.example.demo.services

import com.example.demo.entities.City
import com.example.demo.entities.Municipality
import com.example.demo.entities.Ranch
import com.example.demo.repositories.CityRepository
import com.example.demo.repositories.MunicipalityRepository
import com.example.demo.repositories.RanchRepository
import org.springframework.stereotype.Service

@Service
class CityService(
    val cityRepository: CityRepository,
    val municipalityRepository: MunicipalityRepository,
    val ranchRepository: RanchRepository
    ) : ApiService<City> {

    override fun getAll() : List<City> {
        return cityRepository.findAll()
    }

    override fun getByName(name: String) : List<City> {
        return cityRepository.findByName(name)
    }

    fun save(city: City) : City {
        return cityRepository.save(city)
    }

    fun saveMunicipality(cityId: String, municipality: Municipality) : Municipality {
        val city = cityRepository.findById(cityId).get()

        municipality.city = city

        return municipalityRepository.save(municipality)
    }

    fun saveRanch(cityId: String, ranch: Ranch) : Ranch{
        val city = cityRepository.findById(cityId).get()

        ranch.city = city

        return ranchRepository.save(ranch)
    }

}