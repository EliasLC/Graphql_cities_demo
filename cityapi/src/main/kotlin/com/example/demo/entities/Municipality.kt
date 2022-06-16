package com.example.demo.entities

import com.fasterxml.jackson.annotation.JsonIgnore
import org.hibernate.annotations.GenericGenerator
import javax.persistence.*

@Entity
@Table(name = "municipalities")
data class Municipality(
    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
    var id: String?,
    val name: String,
    var description: String?,
    @ManyToOne
    @JoinColumn(name = "city_id")
    @JsonIgnore
    var city: City?
)
