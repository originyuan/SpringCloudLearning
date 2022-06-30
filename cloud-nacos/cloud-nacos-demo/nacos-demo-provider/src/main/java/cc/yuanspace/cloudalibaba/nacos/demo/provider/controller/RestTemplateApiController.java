package cc.yuanspace.cloudalibaba.nacos.demo.provider.controller;

import cc.yuanspace.cloudalibaba.nacos.demo.common.GoodsDTO;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rest")
public class RestTemplateApiController {

    // 模拟数据库
    private List<GoodsDTO> db = new ArrayList<>();

    // get
    @GetMapping("/goods/{id}")
    public GoodsDTO getById(@PathVariable("id") Long id) {
        return db.stream().filter(e -> e.getId().equals(id)).findFirst().orElse(null);
    }

    @GetMapping("/goods")
    public List<GoodsDTO> list() {
        return db;
    }

    // post
    @PostMapping("/goods")
    public GoodsDTO save(@RequestBody GoodsDTO goodsDTO) {
        db.add(goodsDTO);
        return goodsDTO;
    }

    // put
    @PutMapping("/goods")
    public GoodsDTO update(@RequestBody GoodsDTO goodsDTO) {

        Optional<GoodsDTO> optional = db.stream().filter(e -> e.getId().equals(goodsDTO.getId())).findFirst();
        if (optional.isPresent()) {
            GoodsDTO dto = optional.get();
            dto.setGoodsName(goodsDTO.getGoodsName());
            return dto;
        }
        return null;
    }

    // delete
    @DeleteMapping("/goods/{id}")
    public Boolean delete(@PathVariable("id") Long id) {
        return db.removeIf(e -> e.getId().equals(id));
    }

}
