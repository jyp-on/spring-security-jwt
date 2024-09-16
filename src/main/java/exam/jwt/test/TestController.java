package exam.jwt.test;

import jakarta.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/car")
public class TestController {

    List<Car> cars = new ArrayList<>();

    @PostMapping("/create")
    public ApiResponse<Car> createCar(@Valid @RequestBody Car car) {
        cars.add(car);
        return ApiResponse.createSuccess(car);
    }

    @GetMapping("/list")
    public ApiResponse<List<Car>> getCarList() {
        return ApiResponse.createSuccess(cars);
    }
}
