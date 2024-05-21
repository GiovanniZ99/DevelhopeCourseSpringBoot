package co.develhope.hibernate_es.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@Table(name="classi")
@NoArgsConstructor
@AllArgsConstructor
public class ClassSchool {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String title;
    @Column
    private String description;
    @OneToMany(mappedBy = "classe", cascade = CascadeType.ALL)
    private Set<Enrollment> enrollment;
}
