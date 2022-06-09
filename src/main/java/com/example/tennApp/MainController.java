package com.example.tennApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/courts") // here courts is table's name, case sensitive
public class MainController {
    @Autowired
    private CourtsRepository courtsRepository;

    @PostMapping(path="/add")
    public Courts addNewCourt (@RequestBody Courts court) {
        return courtsRepository.save(court);
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Courts> getAllCourts() {
        return courtsRepository.findAll();
    }

    // path variable
    // http://localhost:8080/courts/nearby/-128.0000/37.0000/5
//    @GetMapping(path="/nearby/{longitude}/{latitude}/{radius}")
//    public @ResponseBody Iterable<Courts> getCourtsNearby(@PathVariable float longitude,
//                                                          @PathVariable float latitude,
//                                                          @PathVariable int radius) {
//        return courtsRepository.findCourtsNearby(longitude, latitude, radius);
//    }

    // request param
    // http://localhost:8080/courts/nearby?longitude=-128.0000&latitude=37.0000&radius=5
    @GetMapping(path="/nearby/")
    public @ResponseBody Iterable<Courts> getCourtsNearby(@RequestParam float longitude,
                                                          @RequestParam float latitude,
                                                          @RequestParam int radius) {
        return courtsRepository.findCourtsNearby(longitude, latitude, radius);
    }
}
