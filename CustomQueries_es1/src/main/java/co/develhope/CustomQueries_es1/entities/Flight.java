package co.develhope.CustomQueries_es1.entities;

import co.develhope.CustomQueries_es1.enums.Status;
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

    @Column(name = "description")
    private String description;

    @Column(name = "from_airport", nullable = false)
    private String fromAirport;

    @Column(name="to_airport", nullable = false)
    private String toAirport;

    @Column(name="status")
    @Enumerated(EnumType.STRING)
    private Status status;
}
