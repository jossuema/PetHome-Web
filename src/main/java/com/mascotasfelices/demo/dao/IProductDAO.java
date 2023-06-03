package com.mascotasfelices.demo.dao;

import com.mascotasfelices.demo.models.Product;
import org.springframework.data.repository.CrudRepository;

public interface IProductDAO extends CrudRepository<Product, Long> {
}
