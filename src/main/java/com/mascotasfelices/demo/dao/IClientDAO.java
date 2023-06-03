package com.mascotasfelices.demo.dao;

import com.mascotasfelices.demo.models.Client;
import org.springframework.data.repository.CrudRepository;

public interface IClientDAO extends CrudRepository<Client, Long> {

}
