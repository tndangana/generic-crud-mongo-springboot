package zw.abn.inventory.service.generics;


import zw.abn.inventory.model.BaseID;
import zw.abn.inventory.repository.generic.GenericRepository;

import java.util.List;
import java.util.Optional;

public abstract class GenericsServiceClass<T extends BaseID,K>  implements IGenericService<T,K> {

    private GenericRepository<T> genericRepository;

    public GenericsServiceClass(GenericRepository<T> genericRepository) {
        this.genericRepository = genericRepository;
    }

    public T save(T t) {
        return genericRepository.save(t);
    }

    public Optional<List<T>> getList() {
        return Optional.ofNullable(genericRepository.findAll());
    }

    public Optional<T> getOne(K id) {
        return Optional.ofNullable(genericRepository.findById(id.toString()).get());
    }

    public void delete(T t) {
         genericRepository.delete(t);
    }

    public void deleteById(K id) {
        genericRepository.deleteById((String) id);
    }

    @Override
    public T update(T t, K id) {
        Optional<T> optional = genericRepository.findById(id.toString());
        if(optional.isPresent()){
            return genericRepository.save(t);
        }
        return null;
    }

}
