package cc.yuanspace.cloudalibaba.nacos.demo.provider.controller;

import cc.yuanspace.cloudalibaba.nacos.demo.common.GoodsDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/goods")
public class GoodsController {

    @GetMapping("/{id}")
    public GoodsDTO findById(@PathVariable("id") Long id) {
        System.out.println("端口为" + System.getProperty("server.port") + "服务被调用" + " goods id = " + id);
        return GoodsDTO.builder().id(id).goodsName("小米"+System.getProperty("server.port")).price(2998L * 100).build();
    }
}
