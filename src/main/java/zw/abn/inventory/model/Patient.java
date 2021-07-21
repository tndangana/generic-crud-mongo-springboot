package zw.abn.inventory.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import zw.abn.inventory.model.genric.GenericAttributes;

@Document(collation = "patient")
@AllArgsConstructor
public class Patient extends GenericAttributes {
}
