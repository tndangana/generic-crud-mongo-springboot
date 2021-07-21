package zw.abn.inventory.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zw.abn.inventory.model.Donor;
import zw.abn.inventory.resource.generics.GenericResource;
import zw.abn.inventory.service.generics.GenericsServiceClass;

@RestController
@RequestMapping("/api/donor")
public class DonorResource extends GenericResource<Donor,String> {
    public DonorResource(GenericsServiceClass<Donor, String> service) {
        super(service);
    }
}
