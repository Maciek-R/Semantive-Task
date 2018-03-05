package pl.semantive.app;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.semantive.app.model.Client;

import java.util.List;

/**
 * Created by Maciek on 2018-03-01.
 */
public interface ClientRepository extends JpaRepository<Client, Long> {
    List<Client> findAllByName(String name);
}
