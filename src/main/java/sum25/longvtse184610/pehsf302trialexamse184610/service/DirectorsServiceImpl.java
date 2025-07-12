package sum25.longvtse184610.pehsf302trialexamse184610.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sum25.longvtse184610.pehsf302trialexamse184610.pojo.Directors;
import sum25.longvtse184610.pehsf302trialexamse184610.repository.DirectorsRepository;

import java.util.List;

@Service
public class DirectorsServiceImpl implements DirectorsService {


    private final DirectorsRepository directorsRepository;
    private DirectorsRepository directorRepository;

    public DirectorsServiceImpl(DirectorsRepository directorRepository, DirectorsRepository directorsRepository) {
        this.directorRepository = directorRepository;
        this.directorsRepository = directorsRepository;
    }

    @Override
    public void saveDirector(Directors director) {
        directorRepository.save(director);
    }


    @Override
    public List<Directors> getAllDirectors() {
        return directorsRepository.findAll();
    }
}
