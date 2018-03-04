package pl.semantive.app.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.semantive.app.client.model.Client;
import pl.semantive.app.clients_telephone.ClientsTelephoneService;
import pl.semantive.app.clients_telephone.model.ClientsTelephone;

import java.util.List;

/**
 * Created by Maciek on 2018-03-01.
 */

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private ClientsTelephoneService clientsTelephoneService;

    @GetMapping
    public List<Client> findAll() {
        return clientService.getAll();
    }

    @GetMapping("/{id}")
    public Client get(@PathVariable Long id) {
        return clientService.get(id);
    }

    @GetMapping("/{clientId}/clients_telephones")
    public List<ClientsTelephone> getClientTelephones(@PathVariable Long clientId) {
        return clientsTelephoneService.getAllByClientId(clientId);
    }

    @PostMapping("/add")
    public Client add(@RequestBody Client client) {

        return clientService.add(client);
    }
}
