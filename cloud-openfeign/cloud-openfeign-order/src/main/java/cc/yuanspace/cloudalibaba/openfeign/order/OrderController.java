package cc.yuanspace.cloudalibaba.openfeign.order;

import cc.yuanspace.cloudalibaba.common.model.HttpResponse;
import cc.yuanspace.cloudalibaba.openfeign.api.PointsApi;
import cc.yuanspace.cloudalibaba.openfeign.model.Points;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private PointsApi pointsApi;

    @PostMapping("/test")
    public HttpResponse<Void> test(@RequestBody Points points) {
//        Points points = new Points(1, 10, "2");
        HttpResponse<Void> response = pointsApi.save(points);
        return response;
    }

    @RequestMapping("/test2")
    public HttpResponse<Void> test2() {
        Points points = new Points(1, 20, "2");
        HttpResponse<Void> response = pointsApi.update(points);
        return response;
    }

    @RequestMapping("/test3")
    HttpResponse<Void> test3(Integer pointsId) {
        HttpResponse<Void> response = pointsApi.deleteById(pointsId);
        return response;
    }


    @RequestMapping("/test4/{pointsId}")
    HttpResponse<Points> test4(@PathVariable("pointsId") Integer pointsId) {
        HttpResponse<Points> response = pointsApi.findById(pointsId);
        return response;
    }

    @RequestMapping("/search")
    HttpResponse<Points> search(Integer pointsId, String type) {
        HttpResponse<Points> response = pointsApi.search(pointsId, type);
        return response;
    }

    @PostMapping("/searchByEntity")
    HttpResponse<List<Points>> searchByEntity(@RequestBody Points points) {
        HttpResponse<List<Points>> response = pointsApi.searchByEntity(points);
        return response;
    }


}
