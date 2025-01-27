package com.gymapp.entities;

import jakarta.persistence.*;

@Entity
@Table(name="tb_roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;
}
