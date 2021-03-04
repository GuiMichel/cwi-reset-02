package br.com.cwi.reset.exemploreset;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/nome")
public class NomeController {

    private static String nome = "Guilherme";

    @GetMapping
    public String nomeTeste() {
        return nome;
    }

    @PutMapping("/{nome}")
    public String mudarNome(@PathVariable String nome) {
        this.nome = nome;
        return this.nome;
    }

    @DeleteMapping
    public void deleteNome(){
        this.nome = null;
    }
}

