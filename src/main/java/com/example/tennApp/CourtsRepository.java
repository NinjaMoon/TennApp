package com.example.tennApp;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface CourtsRepository extends CrudRepository<Courts, Integer> { // courts means Courts class, Integer means id data type
    @Query(value = "SELECT name FROM courts WHERE ST_Distanece_Sphere(point(:lon, :lat), point(longitude, latitude)) * .000621371192 <= :radius",
            nativeQuery = true)
    Iterable<Courts> findCourtsNearby(float lon, float lat, int radius);
}
