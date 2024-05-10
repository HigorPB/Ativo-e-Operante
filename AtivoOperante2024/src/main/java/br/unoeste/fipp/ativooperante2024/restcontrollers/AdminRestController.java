package br.unoeste.fipp.ativooperante2024.restcontrollers;

import br.unoeste.fipp.ativooperante2024.db.entities.Denuncia;
import br.unoeste.fipp.ativooperante2024.db.entities.Orgao;
import br.unoeste.fipp.ativooperante2024.db.repositories.DenunciaRepository;
import br.unoeste.fipp.ativooperante2024.db.repositories.OrgaoRepository;
import br.unoeste.fipp.ativooperante2024.services.DenunciaService;
import br.unoeste.fipp.ativooperante2024.services.OrgaoService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("apis/adm/")
public class AdminRestController {

    @Autowired
    OrgaoService orgaoservice;

    @Autowired
    DenunciaService denserv;

    @GetMapping("teste-conexao")
    public String testeConexao()
    {
        return "conectado";
    }
    // demais apis


        @GetMapping("/delete-orgao")
        public ResponseEntity<Object> excluirOrgao(@RequestParam(value="id") Long id)
        {
            if(orgaoservice.delete(id))
                return new ResponseEntity<>("", HttpStatus.OK);
            else
                return new ResponseEntity<>("", HttpStatus.BAD_REQUEST);

        }

        @PostMapping("/add-orgao")
        public ResponseEntity<Object> salvarOrgao (@RequestBody Orgao orgao)
        {
            Orgao novo;

            novo = orgaoservice.save(orgao);

            return new ResponseEntity<>(novo, HttpStatus.OK);
        }
        @GetMapping("/get-orgao")
        public ResponseEntity<Object> buscarUmOrgao(@RequestParam(value="id") Long id)
        {
            Orgao orgao = orgaoservice.getById(id);

            if(orgao == null)
                orgao = new Orgao();

            return new ResponseEntity<>(orgao,HttpStatus.OK);
        }
        @GetMapping("/get-all-orgaos")
        public ResponseEntity<Object> buscarTodosOrgaos()
        {
            return new ResponseEntity<>(orgaoservice.getAll(),HttpStatus.OK);
        }

    @GetMapping("/get-denuncia")
    public ResponseEntity<Object> buscarUmaDenuncia(@RequestParam(value="id") Long id)
    {
        return new ResponseEntity<>(denserv.getDenuncia(id) ,HttpStatus.OK);
    }

    @GetMapping("/get-all-denuncia")
    public ResponseEntity<Object> listarDenuncias()
    {
        return new ResponseEntity<>(denserv.getAllDenuncias() ,HttpStatus.OK);
    }

    @GetMapping("/delete-denuncia")
    public ResponseEntity<Object> deletaDen (Long id) {

        if(denserv.deleteDen(id))
            return new ResponseEntity<>("", HttpStatus.OK);
        else
            return new ResponseEntity<>("", HttpStatus.BAD_REQUEST);
    }


}
