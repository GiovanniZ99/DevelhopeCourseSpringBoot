package co.develhope.Repository_es2.repositories;

import co.develhope.Repository_es2.entities.Programminglanguage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "repo-prog-languages", collectionResourceRel = "linguaggi di programmazione", itemResourceRel = "linguaggio di programmazione")
public interface ProgrammingLanguageRepository extends JpaRepository<Programminglanguage,Long> {
}
// come dimostro che ho usato postman?