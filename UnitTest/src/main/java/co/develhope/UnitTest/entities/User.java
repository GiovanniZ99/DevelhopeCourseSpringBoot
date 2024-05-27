package co.develhope.UnitTest.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "L'email non può essere nulla")
    @NotBlank(message = "L'email non può essere vuota")
    @Email(message = "Inserisci un indirizzo e-mail valido")
    @Column(nullable = false, unique = true)
    private String email;

    @NotNull(message = "Il nome utente non può essere nullo")
    @NotBlank(message = "Il nome utente non può essere vuoto")
    @Size(min = 5, max = 20)
    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    @NotNull(message = "La password non può essere nulla")
    @NotBlank(message = "La password non può essere vuota")
    @Size(min = 8, max = 100)
    private String password;
}
