package pl.semantive.app.views;

import pl.semantive.app.client.model.Client;
import pl.semantive.app.profession.model.Profession;

/**
 * Created by Maciek on 2018-03-03.
 */
public class ClientProf {

    private Long id;
    private String name;
    private Long age;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getAge() {
        return age;
    }

    public String getProfessionName() {
        return professionName;
    }

    private String professionName;

    public ClientProf(Client client, Profession profession) {
        this.id = client.getId();
        this.name = client.getName();
        this.age = client.getAge();
        this.professionName = profession.getProfessionName();
    }

}
