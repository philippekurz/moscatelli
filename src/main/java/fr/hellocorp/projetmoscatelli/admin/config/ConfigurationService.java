package fr.hellocorp.projetmoscatelli.admin.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConfigurationService {

    @Autowired
    private IRepositoryConfigurations repo;

    public List<Configuration> listeConfigurations() {
        return (List<Configuration>) repo.findAll();
    }

    public void enregistrer(Configuration configuration) {

        repo.save(configuration);
    }

}
