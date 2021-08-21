package com.shannon.online;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.shannon.online.factory.AbstractOrderFactory;
import com.shannon.online.factory.OrderFactoryProducer;
import com.shannon.online.factory.PrimeOrderFactory;
import com.shannon.online.factory.SixHourOrderFactory;
import com.shannon.online.factory.StandardOrderFactory;
import com.shannon.online.entity.order.Order;
import com.shannon.online.entity.order.PrimeOrder;
import com.shannon.online.entity.order.SixHourOrder;
import com.shannon.online.entity.order.StandardOrder;
import com.shannon.online.entity.shipping.PrimeShipping;
import com.shannon.online.entity.shipping.Shipping;
import com.shannon.online.entity.shipping.SixHourShipping;
import com.shannon.online.entity.shipping.StandardShipping;
import com.shannon.online.entity.supplier.PrimeSupplier;
import com.shannon.online.entity.supplier.SixHourSupplier;
import com.shannon.online.entity.supplier.StandardSupplier;
import com.shannon.online.entity.supplier.Supplier;

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
