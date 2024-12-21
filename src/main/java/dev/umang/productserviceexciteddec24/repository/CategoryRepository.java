package dev.umang.productserviceexciteddec24.repository;

import dev.umang.productserviceexciteddec24.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    //Select * from Category where title like 'aparrel'

    //JPA methods => Declared queries

    Category findByTitle(String title);
}
