package br.com.fiap.ufo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Ufo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String location;

    @NotNull
    private LocalDate sightingDate;

    @NotBlank
    private String color;

    @NotNull
    @Enumerated(EnumType.STRING)
    private UfoShape shape;


    @Min(0)
    @Column(name = "quntity_objects")
    private int quantityObjects;
// …

}
