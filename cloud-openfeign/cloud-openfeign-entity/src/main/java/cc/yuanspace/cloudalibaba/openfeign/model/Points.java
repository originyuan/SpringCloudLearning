package cc.yuanspace.cloudalibaba.openfeign.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Points {

    private Integer pointsId;
    private Integer count;
    private String type;

}
