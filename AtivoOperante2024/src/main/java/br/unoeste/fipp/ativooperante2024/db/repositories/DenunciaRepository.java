package br.unoeste.fipp.ativooperante2024.db.repositories;

import br.unoeste.fipp.ativooperante2024.db.entities.Denuncia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DenunciaRepository extends JpaRepository<Denuncia, Long> {

    Object getAll();
}
