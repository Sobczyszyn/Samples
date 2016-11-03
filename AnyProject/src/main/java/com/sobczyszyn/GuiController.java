package com.sobczyszyn;

import com.sobczyszyn.web.repos.Product;
import com.sobczyszyn.web.repos.SimpleProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping("/gui")
public class GuiController {

    @Autowired
    private SimpleProductRepository products;

    @RequestMapping(method = GET)
    public String menu(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("name", auth.getName());
        return "menu";
    }

    @RequestMapping(value = "form", method = GET)
    public String form(@RequestParam(value = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("id", 1);
        return "form";
    }

    @RequestMapping(value = "add")
    public String add(@RequestParam Map<String, String> allRequestParams, Model model) {
        Product save = products.saveAndFlush(new Product(allRequestParams.get("shortName"), allRequestParams.get("description")));
        model.addAttribute("product", save);
        return "ok";
    }

    @RequestMapping(value = "all")
    public String all(Model model) {
        model.addAttribute("products", products.findAll());
        return "all";
    }

    @RequestMapping(value = "allAngular")
    public String allAngular(Model model) {
        model.addAttribute("products", products.findAll());
        return "allAngular";
    }

    @RequestMapping(value = "echo")
    public String echo(@RequestParam Map<String, String> allRequestParams, Model model) {
        model.addAttribute("entries", allRequestParams.entrySet());
        return "echo";
    }
}