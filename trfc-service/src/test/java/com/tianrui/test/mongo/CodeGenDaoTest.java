package com.tianrui.test.mongo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tianrui.service.mongo.CodeGenDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring/appliactionContext-service.xml" })
//@Ignore
public class CodeGenDaoTest {

	@Autowired
	CodeGenDao codeGenDao; 
	@Test
	public void testCode(){
		System.out.println(codeGenDao.codeGen(1));
		
	}
}