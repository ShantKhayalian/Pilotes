package com.app.pilotes.repository;

import com.app.pilotes.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CustomerOrdersRepository extends JpaRepository<Customer, UUID> {

    @Query(value = "SELECT e FROM Customer e WHERE e.id= :id AND e.createdDate >= :time")
    Optional<Customer> findByIdAndCreatedDatePassed5Minutes(@Param("id") UUID uuid, @Param("time") Timestamp timestamp);

    List<Customer> findAllByEmail(@Param("email") String email);

}
