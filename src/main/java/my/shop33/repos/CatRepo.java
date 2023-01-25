package my.shop33.repos;

import my.shop33.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatRepo extends JpaRepository<Category, Long> {
    Category findByName(String name);
}
