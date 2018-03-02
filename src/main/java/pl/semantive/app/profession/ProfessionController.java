package pl.semantive.app.profession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.semantive.app.profession.model.Profession;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Maciek on 2018-03-01.
 */
@RestController
@RequestMapping("/professions")
public class ProfessionController {

    @Autowired
    private ProfessionService professionService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Profession> findAll() {
        return professionService.getAll();
    }

    @PostMapping("/add")
    public Profession add(@RequestBody Profession profession) {
        return professionService.add(profession);
    }
}
