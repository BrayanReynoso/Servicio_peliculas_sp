package com.mx.peliculas.models.genero;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mx.peliculas.models.peliculas.Peliculas;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "genree")
public class Genero {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable = false, length = 50)
    private String genero;

    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "peliculas_id")
    private Peliculas pelicula;
}
