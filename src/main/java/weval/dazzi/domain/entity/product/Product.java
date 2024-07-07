package weval.dazzi.domain.entity.product;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import weval.dazzi.domain.BaseEntity;
import weval.dazzi.domain.entity.seller.Seller;

import static lombok.AccessLevel.PROTECTED;

@Entity
@Table(name = "da_product")
@Getter
@NoArgsConstructor(access = PROTECTED)
public class Product extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    private String name;

    private String description;

    private Double price;

    private Long stockQuantity;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private Seller seller;

//    @OneToMany(mappedBy = "product")
//    private List<Order> orders = new ArrayList();
}
