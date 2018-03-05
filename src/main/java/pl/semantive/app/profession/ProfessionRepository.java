package pl.semantive.app.profession;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.semantive.app.profession.model.Profession;

/**
 * Created by Maciek on 2018-03-01.
 */
@Repository
public interface ProfessionRepository extends JpaRepository<Profession, Long> {
    Profession findByProfessionName(String professionName);
}
