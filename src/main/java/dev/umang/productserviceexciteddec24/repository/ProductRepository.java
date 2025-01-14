package dev.umang.productserviceexciteddec24.repository;

import dev.umang.productserviceexciteddec24.models.Category;
import dev.umang.productserviceexciteddec24.models.Product;
import dev.umang.productserviceexciteddec24.projections.ProductWithIdAndPriceProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Override
    List<Product> findAll();

    @Override
    Page<Product> findAll(Pageable pageable); //pageNo, pageSize - data will given from the fronted
    //from which limit and which offset you need to fetch?
    //pageNo = 20, pageSize = 25
    //pageNo starts from 0 20*25 = 500 retrieved earlier
    //20th page will show 501th to 526th products

    Product save(Product p);

    @Override
    Optional<Product> findById(Long id);

    List<Product> findByCategory(Category category);

    /*
    Will you always have the entire category object when you want to fetch all
    products with an associated category
     */

    List<Product> findAllByCategory_Title(String title);//Declared queries
    /*

     */
    List<Product> findAllByCategory_Id(Long id);

    /*
    We don't have complete control over the query that JPA will execute for us?

    I am interested only in certain columns. I'll provide the query?
    HQL - Similar to SQL but with a small pinch of OOP.
     */

    /*
    Providing the query to JPA can be done :-
    1. HQL
    2. Native SQL
     */

    @Query("select p.id, p.price from Product p where p.category.title = :categoryName")
    List<ProductWithIdAndPriceProjection> getProductTitlesAndPricesAndAGivenCategoryName(@Param("categoryName") String categoryName);

    @Query(value = "select * from products p where p.title = :title", nativeQuery = true)
    List<ProductWithIdAndPriceProjection> getIdAndPricesOfAllProductsWithGivenTitle(@Param("title") String title);
}
