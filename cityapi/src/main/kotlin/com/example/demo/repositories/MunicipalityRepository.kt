package com.example.demo.repositories

import com.example.demo.entities.Municipality
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MunicipalityRepository: JpaRepository<Municipality, String> {

    fun findByName(name: String) : List<Municipality>

}