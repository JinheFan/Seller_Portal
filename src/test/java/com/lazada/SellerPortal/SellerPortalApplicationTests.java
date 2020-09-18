package com.lazada.SellerPortal;

import com.lazada.SellerPortal.entity.AddressEntity;
import com.lazada.SellerPortal.service.impl.AddressServiceImpl;
import com.lazada.SellerPortal.vo.AddressVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SellerPortalApplicationTests {

	@Autowired
	AddressServiceImpl addressService;

	@Test
	public void contextLoads() {
	}

	@Test
	public void serviceTest() {
		String userId = "abc";
		AddressVo addressVo = new AddressVo();
		addressVo.setCity("Tampa");
		addressVo.setCountry("USA");
		addressVo.setPostCode("33612");
		addressVo.setLine1("10420 Mckinley Dr");
		AddressEntity save = addressService.save(addressVo, userId);
		System.out.println(save);
	}

}
