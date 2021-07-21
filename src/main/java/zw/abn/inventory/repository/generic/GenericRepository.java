package zw.abn.inventory.repository.generic;

import org.springframework.data.mongodb.repository.MongoRepository;
import zw.abn.inventory.model.BaseID;


public interface GenericRepository<T extends BaseID> extends MongoRepository<T,String> {
}
