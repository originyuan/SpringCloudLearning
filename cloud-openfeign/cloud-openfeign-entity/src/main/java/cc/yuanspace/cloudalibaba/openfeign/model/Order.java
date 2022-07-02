package cc.yuanspace.cloudalibaba.openfeign.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order {

    private Integer uid;
    private Integer num;
    private String type;

}
