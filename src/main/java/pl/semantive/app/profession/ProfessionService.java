package pl.semantive.app.profession;

import pl.semantive.app.profession.model.Profession;

import java.util.List;

/**
 * Created by Maciek on 2018-03-01.
 */
public interface ProfessionService {
    List<Profession> getAll();
    Profession get(Long id);
    Profession add(Profession profession);
}
