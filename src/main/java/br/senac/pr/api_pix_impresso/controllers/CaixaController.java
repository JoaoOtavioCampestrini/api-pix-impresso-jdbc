package br.senac.pr.api_pix_impresso.controllers;
 
import java.util.List;
 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.senac.pr.api_pix_impresso.dtos.CreateCaixaDto;
import br.senac.pr.api_pix_impresso.dtos.UpdateCaixaDto;
import br.senac.pr.api_pix_impresso.models.Caixa;
import br.senac.pr.api_pix_impresso.repositories.JdbcCaixaRepository;
import br.senac.pr.api_pix_impresso.services.CaixaService;

@RestController
@RequestMapping("/caixas")
public class CaixaController {
private CaixaService caixaService;

public CaixaController (CaixaService caixaService) {
    this.caixaService = caixaService;
}
 
    @GetMapping("")
    public List<Caixa> gatCaixas() {
        return caixaService.findAll();
    }
   
    @PostMapping("")
    public Caixa createCaixa(@RequestBody CreateCaixaDto dto) {
        Caixa caixa = new Caixa(null,
        dto.getLocalizacao(),
        dto.getSaldo());
        //salvar no banco
        int id = caixaService.save(caixa);
        caixa.setId(Long.valueOf(id));
        return caixa;
        //service -> repository
        //retornar objeto caixa id
    }


    // GET - por ID


    //Cria um objeto do modelo
    Caixa caixa = new Caixa (id,
    dto.getLocalizacao(),
    dto.getSaldo());


    // PATCH - Atualização Parcial
    @PatchMapping("")
    public Caixa update (@RequestBody UpdateCaixaDto dto,
    @RequestParam Long id) {
        return new Caixa(null, dto.getLocalizacao(), dto.getSaldo());
    //Atualizar o registro no banco
    caixaService.update(caixa);

    //Retornar o objeto caixa
    return caixa;
    }


    }
    // PUT - Atualização Completa
    // DELETE - Exclusão
