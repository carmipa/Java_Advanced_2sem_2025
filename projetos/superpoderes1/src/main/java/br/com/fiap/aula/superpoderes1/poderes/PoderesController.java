package br.com.fiap.aula.superpoderes1.poderes;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/poderes")
public class PoderesController {

    private final PoderesService poderesService;

    public PoderesController(PoderesService poderesService) {
        this.poderesService = poderesService;
    }

    public String index(Model model){
        var poderes = poderesService.getAllPoderes();
        model.addAttribute("poderes", poderes);
        return "index";
    }

}
