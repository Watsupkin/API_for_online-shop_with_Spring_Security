package my.shop33.repos;

import my.shop33.entities.Good;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodRepo extends JpaRepository<Good, Long> {
    Good getGoodByTitle(String title);
}
