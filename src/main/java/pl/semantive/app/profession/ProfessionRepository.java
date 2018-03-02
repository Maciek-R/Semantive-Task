package pl.semantive.app.profession;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.semantive.app.profession.model.Profession;

/**
 * Created by Maciek on 2018-03-01.
 */
public interface ProfessionRepository extends JpaRepository<Profession, Long> {
}
