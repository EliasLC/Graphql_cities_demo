package com.example.demo.entities

import org.hibernate.annotations.GenericGenerator
import javax.persistence.*

@Entity
@Table(name = "ranches")
data class Ranch(
    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
    var id: String? ,
    val name: String,
    var description: String?,
    @ManyToOne
    @JoinColumn(name = "city_id")
    var city: City?,
    )
