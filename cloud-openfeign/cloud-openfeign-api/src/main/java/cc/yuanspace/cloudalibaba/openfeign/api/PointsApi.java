package cc.yuanspace.cloudalibaba.openfeign.api;

import cc.yuanspace.cloudalibaba.common.model.HttpResponse;
import cc.yuanspace.cloudalibaba.openfeign.model.Points;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 积分接口声明
 */
// value 指定服务名   path指定路径前缀，如果服务有上下文路径时使用
@FeignClient(value = "openfeign-points", path = "/openfeign-points")
@RequestMapping("/points")
public interface PointsApi {

    // 方法结构与服务接口一致，只是没有方法体
    @PostMapping("/save")
    HttpResponse<Void> save(@RequestBody Points points);

    @PutMapping("/update")
    HttpResponse<Void> update(@RequestBody Points points);


    /**
     * 使用url参数时，@RequestParam不可以省略，必须有，用于定义参数的key
     * @param pointsId
     * @return
     */
    @DeleteMapping("/delete")
    HttpResponse<Void> deleteById(@RequestParam("pointsId") Integer pointsId);


    @GetMapping("/{pointsId}")
    HttpResponse<Points> findById(@PathVariable("pointsId") Integer pointsId);

    @GetMapping("/search")
    HttpResponse<Points> search(@RequestParam("pointsId") Integer pointsId, @RequestParam("type") String type);

    @PostMapping("/searchByEntity")
    HttpResponse<List<Points>> searchByEntity(@RequestBody Points points);
}
