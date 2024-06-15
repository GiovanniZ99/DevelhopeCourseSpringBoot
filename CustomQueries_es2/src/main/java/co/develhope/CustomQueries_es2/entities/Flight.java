package co.develhope.CustomQueries_es2.entities;

import co.develhope.CustomQueries_es2.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name ="flights")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

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
