package com.example.demo.controllers

import com.example.demo.entities.City
import com.example.demo.entities.Municipality
import com.example.demo.services.MunicipalityService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/municipalities")
class MunicipalityController(val municipalityService: MunicipalityService) {

    @GetMapping
    fun getAll(@RequestParam name: Optional<String>) : ResponseEntity<List<Municipality>> {
        if(name.isPresent){
            return ResponseEntity.ok(municipalityService.getByName(name.get()))
        }

        return ResponseEntity.ok(municipalityService.getAll())
    }

    @GetMapping("/{id}/city")
    fun getMunicipalityCity(@PathVariable id: String) : ResponseEntity<City>{
        return ResponseEntity.ok(municipalityService.getCity(id))
    }

}