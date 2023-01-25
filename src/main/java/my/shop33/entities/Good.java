package my.shop33.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "t_goods")
@Getter
@Setter
@NoArgsConstructor
public class Good {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private double price;
    private int count;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Category> categories;

    public Good(String title, double price, int count) {
        this.title = title;
        this.price = price;
        this.count = count;
    }
}
