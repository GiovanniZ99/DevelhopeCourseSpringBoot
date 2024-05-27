package co.develhope.checkpoint.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Regista {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    @NotBlank
    @NotNull
    private String name;
    @Column
    @NotBlank
    @NotNull
    private LocalDate birthday;
    @Column
    @NotBlank
    @NotNull
    private String nationality;
}
