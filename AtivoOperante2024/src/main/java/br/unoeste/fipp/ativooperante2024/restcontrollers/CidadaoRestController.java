package br.unoeste.fipp.ativooperante2024.restcontrollers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("apis/cidadao/")
public class CidadaoRestController {
    @GetMapping("teste-conexao")
    public String testeConexao()
    {
        return "conectado";
    }
    // demais apis
}
