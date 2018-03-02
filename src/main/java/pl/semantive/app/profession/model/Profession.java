package pl.semantive.app.profession.model;

import javax.persistence.*;

/**
 * Created by Maciek on 2018-03-01.
 */

@Entity
@Table(name = "profession")
public class Profession {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "profession_id_seq")
    @SequenceGenerator(name = "profession_id_seq", sequenceName = "profession_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "name")
    private String professionName;

    protected Profession() {
    }

    public Profession(String professionName) {
        this.professionName = professionName;
    }

    public Long getId() {
        return id;
    }

    public String getProfessionName() {
        return professionName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setProfessionName(String professionName) {
        this.professionName = professionName;
    }
}
