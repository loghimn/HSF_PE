package sum25.longvtse184610.pehsf302trialexamse184610.service;

import org.springframework.stereotype.Service;
import sum25.longvtse184610.pehsf302trialexamse184610.pojo.Directors;

import java.util.List;


public interface DirectorsService {
    void saveDirector(Directors directors);

    List<Directors> getAllDirectors();
}
