package xyz.wablers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.wablers.dataobject.ProductCategory;

import java.util.List;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory findByCategoryType(Integer categoryType);
}
