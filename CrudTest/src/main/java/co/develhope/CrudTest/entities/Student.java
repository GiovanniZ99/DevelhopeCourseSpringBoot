package co.develhope.CrudTest.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
