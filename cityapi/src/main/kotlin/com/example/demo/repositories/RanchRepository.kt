package com.example.demo.repositories

import com.example.demo.entities.Ranch
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RanchRepository : JpaRepository<Ranch, String> {

    fun findByName(name: String) : List<Ranch>

}