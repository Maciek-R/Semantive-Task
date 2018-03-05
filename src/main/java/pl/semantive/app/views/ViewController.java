package pl.semantive.app.views;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.semantive.app.client.ClientService;
import pl.semantive.app.clients_telephone.ClientsTelephoneService;
import pl.semantive.app.profession.ProfessionService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Maciek on 2018-03-03.
 */
@RestController
public class ViewController {

    @Autowired
    private ProfessionService professionService;

    @Autowired
    private ClientsTelephoneService clientsTelephoneService;

    @Autowired
    private ClientService clientService;

    @GetMapping("/clientsInfo")
    public List<ClientInfo> getClientsProf() {
        return clientService.getAll().stream()
                .map(client -> new ClientInfo(client,
                                    professionService.get(client.getProfessionId()),
                                    clientsTelephoneService.getAllByClientId(client.getId()).size()))
                .collect(Collectors.toList());
    }
}
