package zw.abn.inventory.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import zw.abn.inventory.model.genric.GenericAttributes;

@Data
@Document(collation = "donor")
public class Donor extends GenericAttributes {


}
