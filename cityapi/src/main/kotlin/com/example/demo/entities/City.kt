package com.example.demo.entities

import com.fasterxml.jackson.annotation.JsonIgnore
import org.hibernate.annotations.GenericGenerator
import javax.persistence.*

@Entity
@Table(name = "cities")
data class City(
    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
    var id: String?,
    val name: String,
    var description: String?,
    @JsonIgnore
    @OneToMany(mappedBy = "city")
    var municipalities: List<Municipality>?,
    @JsonIgnore
    @OneToMany(mappedBy = "city")
    var ranches: List<Municipality>?
)