package com.example.demo.repositories

import com.example.demo.entities.City
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CityRepository : JpaRepository<City, String> {

    fun findByName(name: String) : List<City>

}