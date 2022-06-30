package cc.yuanspace.cloudalibaba.nacos.demo.restremplate.controller;

import cc.yuanspace.cloudalibaba.nacos.demo.common.GoodsDTO;
import cc.yuanspace.cloudalibaba.nacos.demo.common.HttpResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class RestTemplateController {
    // 服务名
    private static final String providerServiceName = "nacos-demo-provider";
    // 统一路径
    private static final String providerUrl = "http://%s/nacos-demo-provider/rest";

    private static String getUrl(String path) {
        path = path.startsWith("/") ? path : "/" + path;
        return String.format(providerUrl, providerServiceName) + path;
    }

    private RestTemplate restTemplate;

    public RestTemplateController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    /**
     * 根据id单个查询
     * @param id 查询参数
     * @return 返回单个数据
     */
    @GetMapping("/goods/{id}")
    public HttpResponse<GoodsDTO> getById(@PathVariable("id") Long id) {

        // 响应 ResponseEntity 封装了响应数据和响应头
        ResponseEntity<GoodsDTO> entity = restTemplate.getForEntity(getUrl("/goods/" + id), GoodsDTO.class);
        System.out.println(entity.getHeaders());
        System.out.println(entity.getBody());

        // getForObject 直接返回数据  第一个参数：请求url  第二个参数：响应数据类型
        // url 拼接路径参数
        GoodsDTO object = restTemplate.getForObject(getUrl("/goods/" + id), GoodsDTO.class);
        System.out.println("get " + object);
        return HttpResponse.success(object);
    }

    /**
     * 查询列表
     * @return 返回列表数据
     */
    @GetMapping("/goods")
    public HttpResponse<List<GoodsDTO>> list() {
        // 第一个参数：请求url  第二个参数：响应数据类型
        List list = restTemplate.getForObject(getUrl("/goods"), List.class);
        return HttpResponse.success(list);
    }

    /**
     * 保存
     * @param goodsDTO 参数
     * @return
     */
    @PostMapping("/goods")
    public HttpResponse<GoodsDTO> save(@RequestBody GoodsDTO goodsDTO) {

        ResponseEntity<GoodsDTO> entity = restTemplate.postForEntity(getUrl("/goods"), goodsDTO, GoodsDTO.class);
        System.out.println(entity.getBody());
        System.out.println(entity.getHeaders());

        // 第一个参数：请求url 第二个参数：数据  第二个参数：响应数据类型
        GoodsDTO goods = restTemplate.postForObject(getUrl("/goods"), goodsDTO, GoodsDTO.class);
        return HttpResponse.success(goods);
    }

    /**
     * 根据id修改
     * @param goodsDTO
     * @return
     */
    @PutMapping("/goods")
    public HttpResponse<Void> update(@RequestBody GoodsDTO goodsDTO) {

        // PUT 请求没有返回数据   第一个参数：请求url 第二个参数：数据
        restTemplate.put(getUrl("/goods"), goodsDTO);
        return HttpResponse.success();
    }

    /**
     * 根据id删除
     * @param id
     * @return
     */
    @DeleteMapping("/goods/{id}")
    public HttpResponse<Void> delete(@PathVariable("id") Long id) {

        // DELETE 请求没有响应体   第一个参数：请求url
        restTemplate.delete(getUrl("/goods/" + id));
        return HttpResponse.success();
    }

}
