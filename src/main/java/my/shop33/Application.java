package my.shop33;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/** 1)Перед регистрацией юзера, нужно вручную добавить роли в БД
 * 2) Чтобы проверить функционал админа - вручную добавить роль админа в бд*/
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}