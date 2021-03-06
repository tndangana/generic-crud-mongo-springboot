package zw.abn.inventory.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zw.abn.inventory.model.Patient;
import zw.abn.inventory.resource.generics.GenericResource;
import zw.abn.inventory.service.generics.GenericsServiceClass;

@RestController
@RequestMapping("/api/patient")
public class PatientResource extends GenericResource<Patient,String> {
    public PatientResource(GenericsServiceClass<Patient, String> service) {
        super(service);
    }
}
