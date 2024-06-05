package co.develhope.Interceptor_es2.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="month")
public class Month {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="month_number",nullable = false)
    private int monthNumber;
    @Column(name="english_name", nullable = false)
    private String englishName;
    @Column(name="italian_name", nullable = false)
    private String italianName;
    @Column(name = "german_name", nullable = false)
    private String germanName;

    public Month(int monthNumber, String englishName, String italianName, String germanName) {
        this.monthNumber = monthNumber;
        this.englishName = englishName;
        this.italianName = italianName;
        this.germanName = germanName;
    }
}
