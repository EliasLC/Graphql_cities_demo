package com.example.demo.controllers

import com.example.demo.entities.City
import com.example.demo.entities.Ranch
import com.example.demo.services.RanchService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/ranches")
class RanchController(val ranchService: RanchService) {

    @GetMapping
    fun getAll(@RequestParam name: Optional<String>) : ResponseEntity<List<Ranch>> {
        if(name.isPresent) {
            return ResponseEntity.ok(ranchService.getByName(name.get()))
        }

        return ResponseEntity.ok(ranchService.getAll())
    }

    @GetMapping("/{id}/cities")
    fun getCity(@PathVariable id: String) : ResponseEntity<City> {
        return ResponseEntity.ok(ranchService.getCity(id))
    }
}