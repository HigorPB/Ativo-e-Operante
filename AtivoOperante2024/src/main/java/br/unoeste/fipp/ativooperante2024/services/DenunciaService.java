package br.unoeste.fipp.ativooperante2024.services;

import br.unoeste.fipp.ativooperante2024.db.entities.Denuncia;
import br.unoeste.fipp.ativooperante2024.db.repositories.DenunciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DenunciaService {

    @Autowired
    private DenunciaRepository denrepo;

    public Optional<Denuncia> getDenuncia (Long id)
    {
        return denrepo.findById(id);
    }

    public List<Denuncia> getAllDenuncias()
    {
        return denrepo.findAll();
    }

    public boolean deleteDen (Long id)
    {
        try{
            denrepo.deleteById(id);
        }
        catch (Exception e){
            return false;
        }

        return true;
    }
}
