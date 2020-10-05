package is.hi.hbv501g.nafnaneistar.nafnaneistar.Services.Implementations;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import is.hi.hbv501g.nafnaneistar.nafnaneistar.Entities.NameCard;
import is.hi.hbv501g.nafnaneistar.nafnaneistar.Entities.User;
import is.hi.hbv501g.nafnaneistar.nafnaneistar.Repositories.NameRepository;
import is.hi.hbv501g.nafnaneistar.nafnaneistar.Services.NameService;

@Service
public class NameServiceImplementation implements NameService {

    NameRepository repository;

    @Autowired
    public NameServiceImplementation(NameRepository nameRepo) {
        this.repository = nameRepo;
    }

    public Optional<NameCard> getRandomName(User user) {
        Random r = new Random();
        int size = user.getAvailableNames().size();
        Integer newID = user.getAvailableNames().get(r.nextInt(size));
        return repository.findById(newID);
    }

    @Override
    public NameCard save(NameCard nameCard) {
        return repository.save(nameCard);
    }

    @Override
    public void delete(NameCard nameCard) {
        repository.delete(nameCard);

    }

    @Override
    public List<NameCard> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<NameCard> findById(Integer id) {
        return repository.findById(id);
    }
    
}
