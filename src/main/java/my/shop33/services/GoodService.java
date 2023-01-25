package my.shop33.services;

import my.shop33.entities.Category;
import my.shop33.entities.Good;
import my.shop33.repos.CatRepo;
import my.shop33.repos.GoodRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class GoodService {
    @Autowired
    GoodRepo goodRepo;
    @Autowired
    CatRepo catRepo;

    public boolean addGood(Good good, String cat) {
        Good goodFromDB = goodRepo.getGoodByTitle(good.getTitle());
        if (goodFromDB != null) {
            return false;
        }


        if (isCategoryExists(cat)) good.setCategories(Collections.singleton(catRepo.findByName(cat)));


        goodRepo.save(good);
        return true;
    }

    public boolean isCategoryExists(String cName){
        List<Category> catsFromBd = catRepo.findAll();
        for (Category c : catsFromBd) {
            if (c.getName().equalsIgnoreCase(cName)) return true;
        }
        return false;
    }
}
