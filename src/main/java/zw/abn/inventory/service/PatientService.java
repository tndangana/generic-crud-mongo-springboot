package zw.abn.inventory.service;

import org.springframework.stereotype.Service;
import zw.abn.inventory.model.Patient;
import zw.abn.inventory.repository.generic.GenericRepository;
import zw.abn.inventory.service.generics.GenericsServiceClass;

@Service
public class PatientService extends GenericsServiceClass<Patient,String> {
    public PatientService(GenericRepository<Patient> genericRepository) {
        super(genericRepository);
    }
}
