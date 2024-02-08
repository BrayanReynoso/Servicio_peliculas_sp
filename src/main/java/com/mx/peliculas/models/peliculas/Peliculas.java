package com.mx.peliculas.models.peliculas;

import com.mx.peliculas.models.genero.Genero;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "movies")
public class Peliculas {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable = false, length = 50)
    private String nombre;
    @Column(nullable = false, length = 100)
    private String director;
    @Column(nullable = false, length = 30)
    private String duracion;
    @Column(nullable = false)
    private Boolean status;

    @OneToOne(mappedBy = "pelicula", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Genero genero;
}
