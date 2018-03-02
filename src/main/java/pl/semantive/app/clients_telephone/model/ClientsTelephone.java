package pl.semantive.app.clients_telephone.model;

import javax.persistence.*;

/**
 * Created by Maciek on 2018-03-01.
 */
@Entity
@Table(name = "clients_telephone")
public class ClientsTelephone {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "clients_telephone_id_seq")
    @SequenceGenerator(name = "clients_telephone_id_seq", sequenceName = "clients_telephone_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "number")
    private String number;

    @Column(name = "clientId")
    private Long clientId;

    protected ClientsTelephone() {
    }

    public ClientsTelephone(String number, Long clientId) {
        this.number = number;
        this.clientId = clientId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getId() {

        return id;
    }

    public String getNumber() {
        return number;
    }

    public Long getClientId() {
        return clientId;
    }
}
