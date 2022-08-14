package com.takias.cloud;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.takias.cloud.entity.OrderTo;
import com.takias.cloud.repo.OrderRepository;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderRepoTest {
	
	@Autowired
	private OrderRepository orderRepo;	
	
	@Test
	@Order(1)
	@Rollback(value = false)
	public void saveOrderTest() {
		
		
		OrderTo order = OrderTo.builder()
				.name("TV")
				.price(30000)
				.build();
		
		orderRepo.save(order);
		
		assertThat(order.getId()).isGreaterThan(0);
		
	}
	
	@Test
	@Order(2)
	@Rollback(value = false)
	public void getOrderTest() {
		
		OrderTo order = orderRepo.findById(1L).get();
		
		assertThat(order.getId()).isEqualTo(1L);
		
	}

}
