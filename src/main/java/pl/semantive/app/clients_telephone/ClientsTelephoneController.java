package pl.semantive.app.clients_telephone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.semantive.app.clients_telephone.model.ClientsTelephone;

import java.util.List;

/**
 * Created by Maciek on 2018-03-01.
 */

@RestController
@RequestMapping("/clients_telephones")
public class ClientsTelephoneController {

    @Autowired
    private ClientsTelephoneService clientsTelephoneService;

    @GetMapping
    public List<ClientsTelephone> findAll() {
        return clientsTelephoneService.getAll();
    }

    @GetMapping("/{id}")
    public ClientsTelephone get(@PathVariable Long id) {
        return clientsTelephoneService.get(id);
    }

    @PostMapping
    public ClientsTelephone add(@RequestBody ClientsTelephone clientsTelephone) {
        if(clientsTelephoneService.findByNumber(clientsTelephone.getNumber())!=null)
            return null;

        return clientsTelephoneService.add(clientsTelephone);
    }
}
