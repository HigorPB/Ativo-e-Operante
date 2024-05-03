package br.unoeste.fipp.ativooperante2024.services;

import br.unoeste.fipp.ativooperante2024.db.entities.Denuncia;
import br.unoeste.fipp.ativooperante2024.db.repositories.DenunciaRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class DenunciaService {

    @Autowired
    private DenunciaRepository denrepo;

    public Denuncia getDenuncia (Long id)
    {
        return denrepo.findById(id);
    }
}
