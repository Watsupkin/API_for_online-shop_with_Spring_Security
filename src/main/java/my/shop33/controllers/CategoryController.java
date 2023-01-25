package my.shop33.controllers;

import my.shop33.entities.Category;
import my.shop33.entities.Good;
import my.shop33.repos.CatRepo;
import my.shop33.repos.GoodRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    private CatRepo catRepo;
    @Autowired
    private GoodRepo goodRepo;

    @GetMapping("/add_category")
    public String getNewCategoryForm() {
        return "add_category";
    }
    @PostMapping("/add_category")
    public String addCategory(@RequestParam String catName) {
        Category cat = catRepo.findByName(catName);
        if (cat != null) return "add_category";
        catRepo.save(new Category(catName));
        return "redirect:/goods";
    }
    @GetMapping("/by_cats/{id}")
    public String groupByCategory(@PathVariable(value = "id") long id,
                                  Model model) {
        Category category = catRepo.findById(id).orElse(null);
        List<Good> goods = new ArrayList<>();
        List<Good> allGoods = goodRepo.findAll();
        for (Good g : allGoods) {
            if (g.getCategories().contains(category)) {
                goods.add(g);
            }
        }
        model.addAttribute("goods", goods);

        return "/by_category";
    }
}
