package com.takias.cloud.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.takias.cloud.entity.OrderTo;

public interface OrderRepository extends JpaRepository<OrderTo, Long>{

}
