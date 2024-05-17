package co.develhope.Repositories_es.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="cars")
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @NotNull
    @Column(nullable = false)
    private String modelName;

    @NotBlank
    @NotNull
    @Column(nullable = false)
    private String serialNumber;
    @Column
    private Double currentPrice;
}
