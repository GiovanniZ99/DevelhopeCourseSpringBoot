package co.develhope.CustomQueries_es.entities;

import co.develhope.CustomQueries_es.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="flight")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String fromAirport;

    @Column(nullable = false)
    private String toAirport;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;
}
