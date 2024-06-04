package co.develhope.checkpoint.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    @NotBlank
    @NotNull
    private String fullName;
    @Column(unique = true, nullable = false)
    @NotBlank
    @NotNull
    private String codiceFiscale;
    @Column(nullable = false)
    @NotBlank
    @NotNull
    private String jobPosition;
    @Column(nullable = false)
    @NotBlank
    @NotNull
    @Email
    private String email;
}
