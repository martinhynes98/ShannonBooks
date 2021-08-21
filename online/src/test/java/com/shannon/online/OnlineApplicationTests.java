package com.shannon.online;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OnlineApplicationTests {

	//@BeforeEach
	//void setUp(){
	//	OrderFactoryProducer producer = new OrderFactoryProducer();
	//}

	@Test
	@DisplayName("Ensure Factory Producer Returns Standard Factory")
	void produceStandardFactory() {
		OrderFactoryProducer producer = new OrderFactoryProducer();
		AbstractOrderFactory factory = producer.getOrderFactory("");
		assertTrue(factory instanceof AbstractOrderFactory);
		assertTrue(factory instanceof StandardOrderFactory);
	}

	@Test
	@DisplayName("Ensure Factory Producer Returns Prime Factory")
	void producePrimeFactory() {
		OrderFactoryProducer producer = new OrderFactoryProducer();
		AbstractOrderFactory factory = producer.getOrderFactory("prime");
		assertTrue(factory instanceof AbstractOrderFactory);
		assertTrue(factory instanceof PrimeOrderFactory);
	}

	@Test
	@DisplayName("Ensure Factory Producer Returns Six Hour Factory")
	void produceSixHourFactory() {
		OrderFactoryProducer producer = new OrderFactoryProducer();
		AbstractOrderFactory factory = producer.getOrderFactory("sixhour");
		assertTrue(factory instanceof AbstractOrderFactory);
		assertTrue(factory instanceof SixHourOrderFactory);
	}

	@Test
	@DisplayName("Ensure Standard Order Factory Creates Standard Order, Supplier, and Shipping")
	void standardFactoryTest() {
		AbstractOrderFactory factory = new StandardOrderFactory();
		Order order = factory.createOrder();
		assertTrue(order instanceof Order);
		assertTrue(order instanceof StandardOrder);
		Supplier supplier = factory.createSupplier();
		assertTrue(supplier instanceof Supplier);
		assertTrue(supplier instanceof StandardSupplier);
		Shipping shipping = factory.createShipping();
		assertTrue(shipping instanceof Shipping);
		assertTrue(shipping instanceof StandardShipping);
	}

	@Test
	@DisplayName("Ensure Prime Order Factory Creates Standard Order, Supplier, and Shipping")
	void primeFactoryTest() {
		AbstractOrderFactory factory = new PrimeOrderFactory();
		Order order = factory.createOrder();
		assertTrue(order instanceof Order);
		assertTrue(order instanceof PrimeOrder);
		Supplier supplier = factory.createSupplier();
		assertTrue(supplier instanceof Supplier);
		assertTrue(supplier instanceof PrimeSupplier);
		Shipping shipping = factory.createShipping();
		assertTrue(shipping instanceof Shipping);
		assertTrue(shipping instanceof PrimeShipping);
	}

	@Test
	@DisplayName("Ensure Six Hour Order Factory Creates Standard Order, Supplier, and Shipping")
	void sixHourFactoryTest() {
		AbstractOrderFactory factory = new SixHourOrderFactory();
		Order order = factory.createOrder();
		assertTrue(order instanceof Order);
		assertTrue(order instanceof SixHourOrder);
		Supplier supplier = factory.createSupplier();
		assertTrue(supplier instanceof Supplier);
		assertTrue(supplier instanceof SixHourSupplier);
		Shipping shipping = factory.createShipping();
		assertTrue(shipping instanceof Shipping);
		assertTrue(shipping instanceof SixHourShipping);
	}

}
