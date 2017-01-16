package gen.framework.common.dao.mongodb;

import java.util.List;

import org.springframework.data.mongodb.core.MongoOperations;


public interface  CommonRepository extends MongoOperations {
	public List findByNameLike(String name);
}
