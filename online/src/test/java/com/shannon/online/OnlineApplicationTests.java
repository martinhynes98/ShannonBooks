package com.shannon.online;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.shannon.online.factory.AbstractOrderFactory;
import com.shannon.online.factory.OrderFactoryProducer;
import com.shannon.online.factory.PrimeOrderFactory;
import com.shannon.online.factory.SixHourOrderFactory;
import com.shannon.online.factory.StandardOrderFactory;
import com.shannon.online.data.order.OrderData;
import com.shannon.online.data.shipping.ShippingData;
import com.shannon.online.data.supplier.SupplierData;
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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
class OnlineApplicationTests {

	//@BeforeEach
	//void setUp(){
	//	OrderFactoryProducer producer = new OrderFactoryProducer();
	//}
	@Autowired
	OrderFactoryProducer producer;

	@Test
	@DisplayName("Ensure Factory Producer Returns Standard Factory")
	void produceStandardFactory() {
		AbstractOrderFactory factory = producer.getOrderFactory("");
		assertTrue(factory instanceof AbstractOrderFactory);
		assertTrue(factory instanceof StandardOrderFactory);
	}

	@Test
	@DisplayName("Ensure Factory Producer Returns Prime Factory")
	void producePrimeFactory() {
		AbstractOrderFactory factory = producer.getOrderFactory("prime");
		assertTrue(factory instanceof AbstractOrderFactory);
		assertTrue(factory instanceof PrimeOrderFactory);
	}

	@Test
	@DisplayName("Ensure Factory Producer Returns Six Hour Factory")
	void produceSixHourFactory() {
		AbstractOrderFactory factory = producer.getOrderFactory("sixhour");
		assertTrue(factory instanceof AbstractOrderFactory);
		assertTrue(factory instanceof SixHourOrderFactory);
	}

	@Test
	@DisplayName("Ensure Standard Order Factory Creates Standard Order, Supplier, and Shipping")
	void standardFactoryTest() {
		AbstractOrderFactory factory = producer.getOrderFactory("");
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
		AbstractOrderFactory factory = producer.getOrderFactory("prime");
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
		AbstractOrderFactory factory = producer.getOrderFactory("sixhour");
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

@SpringBootTest
class SQLiteTests {
	
		//@BeforeEach
		//void setUp(){
		//	OrderFactoryProducer producer = new OrderFactoryProducer();
		//}
	@Autowired
	OrderFactoryProducer producer;

	@Test
	void createStandardOrder(){
		AbstractOrderFactory factory = producer.getOrderFactory("standard");
		Order standardOrder = factory.createOrder();
		OrderData createdData = standardOrder.createOrder(1, 2);
		OrderData importedData = standardOrder.getOrder(createdData.getId());
		assertTrue(createdData.getId().equals(importedData.getId()));
	}

	@Test
	void createPrimeOrder(){
		AbstractOrderFactory factory = producer.getOrderFactory("prime");
		Order primeOrder = factory.createOrder();
		OrderData createdData = primeOrder.createOrder(1, 2);
		OrderData importedData = primeOrder.getOrder(createdData.getId());
		assertTrue(createdData.getId().equals(importedData.getId()));
	}

	@Test
	void createSixHourOrder(){
		AbstractOrderFactory factory = producer.getOrderFactory("sixhour");
		Order sixHourOrder = factory.createOrder();
		OrderData createdData = sixHourOrder.createOrder(1, 2);
		OrderData importedData = sixHourOrder.getOrder(createdData.getId());
		assertTrue(createdData.getId().equals(importedData.getId()));
	}

	@Test
	void createStandardShipping(){
		AbstractOrderFactory factory = producer.getOrderFactory("standard");
		Shipping standardShipping = factory.createShipping();
		ShippingData createdData = standardShipping.createShipping(1);
		ShippingData importedData = standardShipping.getShipping(createdData.getId());
		assertTrue(createdData.getId().equals(importedData.getId()));
	}

	@Test
	void createPrimeShipping(){
		AbstractOrderFactory factory = producer.getOrderFactory("prime");
		Shipping primeShipping = factory.createShipping();
		ShippingData createdData = primeShipping.createShipping(1);
		ShippingData importedData = primeShipping.getShipping(createdData.getId());
		assertTrue(createdData.getId().equals(importedData.getId()));
	}

	@Test
	void createSixHourShipping(){
		AbstractOrderFactory factory = producer.getOrderFactory("sixhour");
		Shipping sixHourShipping = factory.createShipping();
		ShippingData createdData = sixHourShipping.createShipping(1);
		ShippingData importedData = sixHourShipping.getShipping(createdData.getId());
		assertTrue(createdData.getId().equals(importedData.getId()));
	}

	@Test
	void createStandardSupplier(){
		AbstractOrderFactory factory = producer.getOrderFactory("standard");
		Supplier standardSupplier = factory.createSupplier();
		SupplierData createdData = standardSupplier.createSupplier(1);
		SupplierData importedData = standardSupplier.getSupplier(createdData.getId());
		assertTrue(createdData.getId().equals(importedData.getId()));
	}

	@Test
	void createPrimeSupplier(){
		AbstractOrderFactory factory = producer.getOrderFactory("prime");
		Supplier primeSupplier = factory.createSupplier();
		SupplierData createdData = primeSupplier.createSupplier(1);
		SupplierData importedData = primeSupplier.getSupplier(createdData.getId());
		assertTrue(createdData.getId().equals(importedData.getId()));
	}



	@Test
	void createSixHourSupplier(){
		AbstractOrderFactory factory = producer.getOrderFactory("sixhour");
		Supplier sixHourSupplier = factory.createSupplier();
		SupplierData createdData = sixHourSupplier.createSupplier(1);
		SupplierData importedData = sixHourSupplier.getSupplier(createdData.getId());
		assertTrue(createdData.getId().equals(importedData.getId()));
	}

}