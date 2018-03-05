package pl.semantive.app.profession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.semantive.app.profession.model.Profession;

import java.util.List;

/**
 * Created by Maciek on 2018-03-01.
 */
@Service
public class ProfessionServiceImpl implements ProfessionService{

    @Autowired
    private ProfessionRepository professionRepository;


    @Override
    public List<Profession> getAll() {
        return professionRepository.findAll();
    }

    @Override
    public Profession get(Long id) {
        return professionRepository.findOne(id);
    }

    @Override
    public Profession add(Profession profession) {
        return professionRepository.save(profession);
    }

    @Override
    public Profession findByProfessionName(String professionName) {
        return professionRepository.findByProfessionName(professionName);
    }
}
