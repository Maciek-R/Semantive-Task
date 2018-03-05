package pl.semantive.app;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.semantive.app.model.Client;
import pl.semantive.app.clients_telephone.ClientsTelephoneRepository;
import pl.semantive.app.clients_telephone.model.ClientsTelephone;
import pl.semantive.app.profession.ProfessionRepository;
import pl.semantive.app.profession.model.Profession;

import java.util.List;

/**
 * Created by Maciek on 2018-03-03.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class JpaTester {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ProfessionRepository professionRepository;

    @Autowired
    private ClientsTelephoneRepository clientsTelephoneRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Test
    public void testFindProfession() throws Exception {
        entityManager.persist(new Profession("Strażak"));
        entityManager.persist(new Profession("Lekarz"));
        Profession profession = this.professionRepository.findByProfessionName("Strażak");
        Assert.assertEquals(profession.getProfessionName(), "Strażak");
    }

    @Test
    public void testProfessionSize() throws Exception {
        entityManager.persist(new Profession("Strażak"));
        entityManager.persist(new Profession("Lekarz"));
        Assert.assertEquals(professionRepository.findAll().size(), 2);
    }

    @Test
    public void testFindClient() throws Exception {
        entityManager.persist(new Client("Maciek", Long.valueOf(27), Long.valueOf(0)));
        entityManager.persist(new Client("Maciek", Long.valueOf(25), Long.valueOf(2)));
        List<Client> clients = clientRepository.findAllByName("Maciek");
        Assert.assertEquals(clients.size(), 2);
    }

    @Test
    public void testClientsTelephones() throws Exception {
        Client c1 = new Client("M", Long.valueOf(26), Long.valueOf(1));
        Client c2 = new Client("A", Long.valueOf(28), Long.valueOf(2));
        entityManager.persist(c1);
        entityManager.persist(c2);
        entityManager.persist(new ClientsTelephone("123123123", c1.getId()));
        entityManager.persist(new ClientsTelephone("123123124", c1.getId()));
        entityManager.persist(new ClientsTelephone("123123126", c1.getId()));
        entityManager.persist(new ClientsTelephone("123123125", c2.getId()));

        Assert.assertEquals(clientsTelephoneRepository.findAllByClientId(c1.getId()).size(), 3);
        List<ClientsTelephone> t = clientsTelephoneRepository.findAll();
        Assert.assertEquals(clientsTelephoneRepository.findAll().size(), 4);
    }

    @Test
    public void testDeleteClient() throws Exception {
        Client c1 = new Client("M", Long.valueOf(26), Long.valueOf(1));
        Client c2 = new Client("A", Long.valueOf(28), Long.valueOf(2));
        entityManager.persist(c1);
        entityManager.persist(c2);
        entityManager.persist(new ClientsTelephone("123123123", c1.getId()));
        entityManager.persist(new ClientsTelephone("123123124", c1.getId()));
        entityManager.persist(new ClientsTelephone("123123126", c1.getId()));
        entityManager.persist(new ClientsTelephone("123123125", c2.getId()));

        clientsTelephoneRepository.findAllByClientId(c1.getId()).stream().forEach(cT->clientsTelephoneRepository.delete(cT.getId()));
        clientRepository.delete(c1.getId());

        Assert.assertEquals(clientsTelephoneRepository.findAll().size(), 1);
        Assert.assertEquals(clientRepository.findAll().size(), 1);
    }
}
