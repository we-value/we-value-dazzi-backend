package weval.dazzi.domain.entity.product.acess.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import weval.dazzi.domain.entity.product.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
