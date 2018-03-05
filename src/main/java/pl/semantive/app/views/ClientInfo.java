package pl.semantive.app.views;

import pl.semantive.app.client.model.Client;
import pl.semantive.app.profession.model.Profession;

/**
 * Created by Maciek on 2018-03-03.
 */
public class ClientInfo {

    private Long id;
    private String name;
    private Long age;
    private String professionName;
    private int telephonesCount;

    public int getTelephonesCount() {
        return telephonesCount;
    }

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



    public ClientInfo(Client client, Profession profession, int telephonesCount) {
        this.id = client.getId();
        this.name = client.getName();
        this.age = client.getAge();
        this.professionName = profession.getProfessionName();
        this.telephonesCount = telephonesCount;
    }

}
