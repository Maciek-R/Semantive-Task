package pl.semantive.app.clients_telephone;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.semantive.app.clients_telephone.model.ClientsTelephone;

import java.util.List;

/**
 * Created by Maciek on 2018-03-01.
 */
public interface ClientsTelephoneRepository extends JpaRepository<ClientsTelephone, Long>{
    List<ClientsTelephone> findAllByClientId(Long id);
}
