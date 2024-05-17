package co.develhope.Crud_es.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="macchine")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // doppia validazione per sicurezza, sia lato java che lato server
    @Column(nullable = false)
    @NotNull(message = "niente null")
    @NotBlank(message = "niente vuoto")
    private String modelName;
    @Column
    @NotBlank(message = "niente vuoto")
    private String type;

}
