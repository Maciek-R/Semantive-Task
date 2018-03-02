package pl.semantive.app.clients_telephone;

import pl.semantive.app.clients_telephone.model.ClientsTelephone;

import java.util.List;

/**
 * Created by Maciek on 2018-03-01.
 */
public interface ClientsTelephoneService {
    List<ClientsTelephone> getAll();
    ClientsTelephone get(Long id);
    List<ClientsTelephone> getAllByClientId(Long clientId);
    ClientsTelephone add(ClientsTelephone client);
}
