package com.baeldung.kotlin.jpa

import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.ManyToMany
import javax.persistence.JoinTable
import javax.persistence.JoinColumn

@Entity
data class Person @JvmOverloads constructor(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Int,
        @Column(nullable = false)
        val name: String,
        @Column(nullable = true)
        val email: String? = null,
        @ManyToMany(cascade = arrayOf(CascadeType.ALL))
    @JoinTable(name = "person_nr",
					joinColumns = arrayOf(JoinColumn(name = "person_id", referencedColumnName = "id")),
					inverseJoinColumns = arrayOf(JoinColumn(name = "phone_id", referencedColumnName = "id")))
	val phoneNumbers: Set<PhoneNumber>? = null
        )
