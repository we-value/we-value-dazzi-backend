package weval.dazzi.domain.entity.seller.access.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import weval.dazzi.domain.entity.seller.Seller;

public interface SellerRepository extends JpaRepository<Seller, Long> {
}
