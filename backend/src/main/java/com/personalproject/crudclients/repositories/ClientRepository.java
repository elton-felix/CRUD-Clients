package com.personalproject.crudclients.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.personalproject.crudclients.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{

}
