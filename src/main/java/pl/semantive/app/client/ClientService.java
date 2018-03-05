package pl.semantive.app.client;

import pl.semantive.app.client.model.Client;

import java.util.List;

/**
 * Created by Maciek on 2018-03-01.
 */
public interface ClientService {
    List<Client> getAll();
    Client get(Long id);
    Client add(Client client);
    void delete(Long id);
}
