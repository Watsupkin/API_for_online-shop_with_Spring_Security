package my.shop33.controllers;

import my.shop33.entities.Good;
import my.shop33.repos.CatRepo;
import my.shop33.repos.GoodRepo;
import my.shop33.services.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class GoodController {
    @Autowired
    private GoodRepo goodRepo;
    @Autowired
    private CatRepo catRepo;
    @Autowired
    GoodService goodService;

    @GetMapping("/goods")
    public String getCatalog(Model model) {
        model.addAttribute("goods", goodRepo.findAll());
        model.addAttribute("categories", catRepo.findAll());

        return "/goods";
    }
    @GetMapping("/add_good")
    public String getAddForm(Model model) {
        model.addAttribute("goodForm", new Good());
        model.addAttribute("categories", catRepo.findAll());

        return "add_good";
    }

    @PostMapping("/add_good")
    public String addGood(@ModelAttribute("goodForm") Good goodForm,
                          @RequestParam String catName) {
        if (goodService.addGood(goodForm, catName)){
            return "redirect:/goods";
        }

        return "add_good";
    }

    @GetMapping("/change_good/{id}")
    public String getCngForm(@PathVariable(value = "id") long id, Model model) {

        model.addAttribute("categories", catRepo.findAll());
        Good good = goodRepo.findById(id).orElse(null);
        model.addAttribute("oldGood", good);

        return "change_good";
    }

    @PostMapping("/change_good/{id}")
    public String chnGood(@ModelAttribute("goodForm") Good goodForm,
                          @RequestParam String catName) {
        goodRepo.findById(goodForm.getId()).ifPresent(oldGood -> goodRepo.delete(oldGood));
        if (goodService.addGood(goodForm, catName)){
            return "redirect:/goods";
        }
        return "change_good";
    }

    @GetMapping("/change_good_count/{id}")
    public String getCountForm(@PathVariable(value = "id") long id, Model model) {
        Good good = goodRepo.findById(id).orElse(null);
        model.addAttribute("good", good);

        return "change_good_count";
    }
    @PostMapping("/change_good_count/{id}")
    public String chnGoodCount(@RequestParam int count,
                               @PathVariable(value = "id") long id) {
        Good good = goodRepo.findById(id).orElse(null);
        good.setCount(good.getCount() - count);
        goodRepo.save(good);
        return "redirect:/goods";
    }
}
