package br.com.fiap.ufo.controller;

import br.com.fiap.ufo.model.Ufo;
import br.com.fiap.ufo.service.UfoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/ufos")
@RequiredArgsConstructor
public class UfoController {

    private final UfoService service;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("ufos", service.findAll());
        return "ufo-index"; // templates/ufo-index.html
    }

    @GetMapping("/new")
    public String newForm(Model model) {
        model.addAttribute("ufo", new Ufo());
        return "ufo-form"; // templates/ufo-form.html
    }

    @PostMapping
    public String create(@Valid @ModelAttribute("ufo") Ufo ufo,
                         BindingResult br,
                         RedirectAttributes ra) {
        if (br.hasErrors()) return "ufo-form";
        service.save(ufo);
        ra.addFlashAttribute("msg", "Avistamento criado!");
        return "redirect:/ufos";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        Ufo found = service.findById(id);
        model.addAttribute("ufo", found);
        return "ufo-form";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable Long id,
                         @Valid @ModelAttribute("ufo") Ufo ufo,
                         BindingResult br,
                         RedirectAttributes ra) {
        if (br.hasErrors()) return "ufo-form";
        ufo.setId(id);
        service.save(ufo);
        ra.addFlashAttribute("msg", "Avistamento atualizado!");
        return "redirect:/ufos";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes ra) {
        service.deleteById(id);
        ra.addFlashAttribute("msg", "Avistamento removido!");
        return "redirect:/ufos";
    }
}
