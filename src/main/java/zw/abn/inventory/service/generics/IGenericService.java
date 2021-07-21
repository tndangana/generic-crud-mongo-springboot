package zw.abn.inventory.service.generics;

import java.util.List;
import java.util.Optional;

public interface IGenericService<T,K> {

     T save(T t);
     Optional<List<T>> getList();
     Optional<T> getOne(K id);
     void delete(T t);
     void deleteById(K id);
     T update(T t,K id);



}
