package pl.semantive.app.clients_telephone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.semantive.app.clients_telephone.model.ClientsTelephone;

import java.util.List;

/**
 * Created by Maciek on 2018-03-01.
 */
@Service
public class ClientsTelephoneServiceImpl implements ClientsTelephoneService{

    @Autowired
    private ClientsTelephoneRepository clientsTelephoneRepository;

    @Override
    public List<ClientsTelephone> getAll() {
        return clientsTelephoneRepository.findAll();
    }

    @Override
    public ClientsTelephone get(Long id) {
        return clientsTelephoneRepository.findOne(id);
    }

    @Override
    public List<ClientsTelephone> getAllByClientId(Long clientId) {
        return clientsTelephoneRepository.findAllByClientId(clientId);
    }

    @Override
    public ClientsTelephone add(ClientsTelephone clientsTelephone) {
        return clientsTelephoneRepository.save(clientsTelephone);
    }

    @Override
    public ClientsTelephone findByNumber(String number) {
        return clientsTelephoneRepository.findByNumber(number);
    }
}
