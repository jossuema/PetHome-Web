package com.mascotasfelices.demo.dao;

import com.mascotasfelices.demo.models.Pet;
import org.springframework.data.repository.CrudRepository;

public interface IPetDAO extends CrudRepository<Pet, Long> {
}
