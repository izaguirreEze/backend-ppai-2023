package com.ppai.backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "estados")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Estado {
    @Id
    @Column(name = "estado_id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Basic
    private String nombre;
}
