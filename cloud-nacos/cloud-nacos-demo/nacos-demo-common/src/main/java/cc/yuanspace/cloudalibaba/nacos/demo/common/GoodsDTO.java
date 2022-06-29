package cc.yuanspace.cloudalibaba.nacos.demo.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GoodsDTO {

    private Long id;

    private String goodsName;

    private Long price;
}
