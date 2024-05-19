package co.develhope.Repository_es2.repositories;

import co.develhope.Repository_es2.entities.Programminglanguage;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.awt.print.Pageable;

@RepositoryRestResource(path = "linguaggi", collectionResourceRel = "linguaggi di programmazione",
        itemResourceRel = "linguaggio di programmazione")
public interface ProgrammingLanguageRepository extends JpaRepository<Programminglanguage,Long> {
    Page<Programminglanguage> findAll(Pageable pageable);
}
