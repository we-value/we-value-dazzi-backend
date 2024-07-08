package weval.dazzi.domain.entity.payment;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import weval.dazzi.domain.BaseEntity;
import weval.dazzi.domain.entity.order.Order;

import static lombok.AccessLevel.PROTECTED;

@Entity
@Table(name = "da_payment")
@Getter
@NoArgsConstructor(access = PROTECTED)
public class Payment extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;

    private String paymentMethod;
    private String amount;
    private String status;

    @OneToOne(mappedBy = "payment", fetch = FetchType.LAZY)
    private Order order;
}
