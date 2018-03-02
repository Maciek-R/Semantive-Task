package pl.semantive.app.client.model;

import javax.persistence.*;

/**
 * Created by Maciek on 2018-02-27.
 */

@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "client_id_seq")
    @SequenceGenerator(name = "client_id_seq", sequenceName = "client_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Long age;

    @Column(name = "profession_id")
    private Long professionId;

    protected Client(){
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {

        return id;
    }

    public Client(Long id, String name, Long age, Long professionId){
        this.id = id;
        this.name = name;
        this.age = age;
        this.professionId = professionId;
    }

    public Client(String name, Long age, Long professionId){
        this.name = name;
        this.age = age;
        this.professionId = professionId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public void setProfessionId(Long professionId) {
        this.professionId = professionId;
    }

    public String getName() {

        return name;
    }

    public Long getAge() {
        return age;
    }

    public Long getProfessionId() {
        return professionId;
    }
}
