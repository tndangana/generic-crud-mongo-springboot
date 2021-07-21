package zw.abn.inventory.model.genric;

import lombok.Data;
import zw.abn.inventory.model.BaseID;
import zw.abn.inventory.model.Sex;

@Data
public class GenericAttributes  extends BaseID {
    private String name;
    private String surname;
    private Integer age;
    private Sex sex;
}
