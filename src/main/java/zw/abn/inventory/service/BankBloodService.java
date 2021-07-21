package zw.abn.inventory.service;

import org.springframework.stereotype.Service;
import zw.abn.inventory.model.BankBlood;
import zw.abn.inventory.repository.generic.GenericRepository;
import zw.abn.inventory.service.generics.GenericsServiceClass;


@Service
public class BankBloodService extends GenericsServiceClass<BankBlood,String> {

    public BankBloodService(GenericRepository<BankBlood> genericRepository) {
        super(genericRepository);
    }


}
