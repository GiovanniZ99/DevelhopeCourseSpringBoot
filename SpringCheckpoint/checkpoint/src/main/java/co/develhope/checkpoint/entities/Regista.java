package co.develhope.checkpoint.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="registi")
public class Regista {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    @NotNull
    @NotBlank
    private String nome;
    @Column(nullable = false)
    @NotBlank
    @NotNull
    private String nationality;
    @Column
    @NotBlank
    @NotNull
    private LocalDate birthday;
}
