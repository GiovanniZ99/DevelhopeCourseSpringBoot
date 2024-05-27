package co.develhope.CrudTest.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
@Data
@Entity
@Table(name="students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    @NotNull
    @NotBlank
    private String name;

    @Column(nullable = false)
    @NotNull
    @NotBlank
    private String surname;

    @Column(nullable = false, unique = true)
    @NotNull
    @NotBlank
    String codiceFiscale;

    @Column(nullable = false)
    @NotNull
    private Boolean isWorking;

}
