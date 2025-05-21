package org.lessons.java.spring_la_mia_pizzeria_crud.controller;

import java.util.List;
import java.util.Optional;

import org.lessons.java.spring_la_mia_pizzeria_crud.model.Pizza;
import org.lessons.java.spring_la_mia_pizzeria_crud.repo.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/pizzas")
public class PizzaController {

    @Autowired
    private PizzaRepository repository;

    @GetMapping
    public String pizzasIndex(Model model) {
        List<Pizza> pizzas = repository.findAll();
        model.addAttribute("pizzas", pizzas);
        return "pizzas/index";
    }

    @GetMapping("/{id}")
    public String getMethodName(@PathVariable("id") Integer id, Model model) {
        Pizza pizza = repository.findById(id).get();
        model.addAttribute(pizza);
        return "pizzas/show";
    }
    
    @GetMapping("/search")
    public String getMethodName(@RequestParam("name") String name, Model model) {
        List<Pizza> pizzas = repository.findByNameContaining(name);
        model.addAttribute("pizzas", pizzas);
        return "pizzas/index";
    }
}
