/*
 * Copyright 2014-2021 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package example.springdata.rest.projections;

import example.springdata.rest.projections.Customer.Gender;

import java.math.BigDecimal;

import io.swagger.v3.oas.models.*;
import io.swagger.v3.oas.models.info.Info;
import jakarta.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author Oliver Gierke
 */
@SpringBootApplication
public class Application {

	@Autowired CustomerRepository customers;
	@Autowired OrderRepository orders;

	public static void main(String... args) {
		SpringApplication.run(Application.class, args);
	}

	public @PostConstruct void init() {

		var dave = customers.save(new Customer("Dave", "Matthews", Gender.MALE, //
				new Address("4711 Some Place", "54321", "Charlottesville", "VA")));

		var order = new Order();

		order.setCustomer(dave);
		order.add(new LineItem("Lakewood guitar", new BigDecimal("1299.0")));

		orders.save(order);
	}

	@Bean
	public OpenAPI serviceApi() {
		return new OpenAPI().info(info());
	}

	public Info info() {
		Info info = new Info();
		info.setTitle("DEMO API");
		info.setVersion("1.2.3");
		return info;
	}
}
