package cc.yuanspace.cloudalibaba.openfeign.points;

import cc.yuanspace.cloudalibaba.common.model.HttpResponse;
import cc.yuanspace.cloudalibaba.openfeign.model.Points;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/points")
public class PointsController {

    List<Points> db = new ArrayList<>();

    @PostMapping("/save")
    public HttpResponse<Void> save(@RequestBody Points points) {
        System.out.println("添加积分 "+points);
        db.add(points);
        return HttpResponse.success();
    }

    @PutMapping("/update")
    public HttpResponse<Void> update(@RequestBody Points points)  {
        System.out.println("更新积分 " + points);
        db.stream()
                .filter(e -> e.getPointsId().equals(points.getPointsId()))
                .peek(e -> {
                    e.setType(points.getType());
                    e.setCount(points.getCount());
                });

        return HttpResponse.success();
    }

    @DeleteMapping("/delete")
    public HttpResponse<Void> deleteById(Integer pointsId) {
        System.out.println("删除id=" + pointsId);

        db.removeIf(e -> e.getPointsId().equals(pointsId));
        return HttpResponse.success();
    }


    @GetMapping("/{pointsId}")
    public HttpResponse<Points> findById(@PathVariable("pointsId") Integer pointsId) {
        Optional<Points> optional = db.stream().filter(e -> e.getPointsId().equals(pointsId)).findFirst();
        return HttpResponse.success(optional.orElse(null));
    }

    @GetMapping("/search")
    public HttpResponse<Points> search(Integer pointsId, String type) {

        System.out.println("搜索条件：" + pointsId + " " + type);

        Optional<Points> optional = db.stream()
                .filter(e -> e.getPointsId().equals(pointsId) && e.getType().equals(type))
                .findFirst();
        return HttpResponse.success(optional.orElse(null));
    }

    @PostMapping("/searchByEntity")
    public HttpResponse<List<Points>> searchByEntity(@RequestBody Points points) {
        System.out.println("搜索条件 entity：" + points);
        return HttpResponse.success(db);
    }

}
