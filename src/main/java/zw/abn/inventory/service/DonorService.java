package zw.abn.inventory.service;

import org.springframework.stereotype.Service;
import zw.abn.inventory.model.Donor;
import zw.abn.inventory.repository.generic.GenericRepository;
import zw.abn.inventory.service.generics.GenericsServiceClass;

@Service
public class DonorService extends GenericsServiceClass<Donor,String> {

    public DonorService(GenericRepository<Donor> genericRepository) {
        super(genericRepository);
    }
}
