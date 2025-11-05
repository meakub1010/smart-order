package com.smart.order.management.repository;

import com.smart.order.management.model.Order;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query("SELECT o FROM Order o WHERE LOWER(o.item) LIKE LOWER(CONCAT('%', :item, '%'))")
    List<Order> findByItemName(@Param("item") String item);
}
