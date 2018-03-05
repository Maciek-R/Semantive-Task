package pl.semantive.app.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.semantive.app.client.ClientRepository;
import pl.semantive.app.client.ClientService;
import pl.semantive.app.client.model.Client;

import java.util.List;

/**
 * Created by Maciek on 2018-03-01.
 */
@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client get(Long id) {
        return clientRepository.findOne(id);
    }

    @Override
    public Client add(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public void delete(Long id) {
        clientRepository.delete(id);
    }
}
