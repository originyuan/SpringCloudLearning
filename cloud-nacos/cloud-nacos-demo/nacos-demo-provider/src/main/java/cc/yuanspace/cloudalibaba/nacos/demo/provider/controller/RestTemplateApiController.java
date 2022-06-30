package cc.yuanspace.cloudalibaba.nacos.demo.provider.controller;

import cc.yuanspace.cloudalibaba.nacos.demo.common.GoodsDTO;
import cc.yuanspace.cloudalibaba.nacos.demo.common.HttpResponse;
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
    public HttpResponse<GoodsDTO> getById(@PathVariable("id") Long id) {
        return HttpResponse.success(db.stream().filter(e -> e.getId().equals(id)).findFirst().orElse(null));
    }

    @GetMapping("/goods")
    public HttpResponse<List<GoodsDTO>> list() {
        return HttpResponse.success(db);
    }

    // post
    @PostMapping("/goods")
    public HttpResponse<GoodsDTO> save(@RequestBody GoodsDTO goodsDTO) {
        db.add(goodsDTO);
        return HttpResponse.success(goodsDTO);
    }

    // put
    @PutMapping("/goods")
    public HttpResponse<GoodsDTO> update(@RequestBody GoodsDTO goodsDTO) {
        if (goodsDTO == null || goodsDTO.getId() == null) {
            return HttpResponse.error("参数错误");
        }
        Optional<GoodsDTO> optional = db.stream().filter(e -> e.getId().equals(goodsDTO.getId())).findFirst();
        if (optional.isPresent()) {
            GoodsDTO dto = optional.get();
            dto.setGoodsName(goodsDTO.getGoodsName());
            return HttpResponse.success(dto);
        }
        return HttpResponse.error("不存在");
    }

    // delete
    @DeleteMapping("/goods/{id}")
    public HttpResponse<Boolean> delete(@PathVariable("id") Long id) {
        boolean b = db.removeIf(e -> e.getId().equals(id));
        return HttpResponse.success(b);
    }

}
