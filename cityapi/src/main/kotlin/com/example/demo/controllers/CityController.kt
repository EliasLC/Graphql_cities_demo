package com.example.demo.controllers

import com.example.demo.entities.City
import com.example.demo.entities.Municipality
import com.example.demo.entities.Ranch
import com.example.demo.services.CityService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/cities")
class CityController(val cityService: CityService) {

    @GetMapping
    fun getCities(@RequestParam name: Optional<String>) : ResponseEntity<List<City>> {
        if(name.isPresent) {
            return ResponseEntity.ok(cityService.getByName(name.get()))
        }

        return ResponseEntity.ok(cityService.getAll());
    }

    @PostMapping
    fun save(@RequestBody city: City) : ResponseEntity<City>{
        return ResponseEntity.ok(cityService.save(city))
    }

    @PostMapping("/{id}/municipalities")
    fun saveMunicipality(@PathVariable id: String, @RequestBody municipality: Municipality) : ResponseEntity<Municipality> {
        return ResponseEntity.ok(cityService.saveMunicipality(id, municipality))
    }

    @PostMapping("/{id}/ranches")
    fun saveRanch(@PathVariable id: String, @RequestBody ranch: Ranch) : ResponseEntity<Ranch> {
        return ResponseEntity.ok(cityService.saveRanch(id, ranch))
    }

}