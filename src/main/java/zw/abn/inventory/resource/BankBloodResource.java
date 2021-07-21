package zw.abn.inventory.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zw.abn.inventory.model.BankBlood;
import zw.abn.inventory.resource.generics.GenericResource;
import zw.abn.inventory.service.generics.GenericsServiceClass;

@RestController
@RequestMapping("/api/bankblood")
public class BankBloodResource extends GenericResource<BankBlood> {
    public BankBloodResource(GenericsServiceClass<BankBlood, String> service) {
        super(service);
    }
}
