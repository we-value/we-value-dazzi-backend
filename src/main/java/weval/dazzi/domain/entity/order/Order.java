package weval.dazzi.domain.entity.order;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import weval.dazzi.domain.BaseEntity;
import weval.dazzi.domain.entity.member.Member;
import weval.dazzi.domain.entity.product.Product;

import static lombok.AccessLevel.PROTECTED;

@Entity
@Table(name = "da_order")
@Getter
@NoArgsConstructor(access = PROTECTED)
public class Order extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    private Double amount;

    private String status;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

//    @OneToOne(mappedBy = "order")
//    private Payment payment;
}
