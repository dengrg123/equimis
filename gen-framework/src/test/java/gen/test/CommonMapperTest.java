package gen.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import gen.framework.common.beans.Users;

@SuppressWarnings(value={"rawtypes","unchecked"})
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CommonMapperTest {
	
	@Autowired
	private MongoOperations  mongoOperations ;


	
	@Test
	public void testBeanGetObject(){
		
		System.out.println("----"+mongoOperations.findOne(new Query(Criteria.where("name").is("kaif")), Users.class));
	}
	

}
