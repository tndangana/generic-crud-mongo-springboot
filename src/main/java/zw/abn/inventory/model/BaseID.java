package zw.abn.inventory.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

@Data
public class BaseID {

    @Id
    private String id;
    private LocalDate createdAt;
    private LocalDate updatedAt;



}
