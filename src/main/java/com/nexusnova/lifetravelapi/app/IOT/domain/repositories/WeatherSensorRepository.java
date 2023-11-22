package com.nexusnova.lifetravelapi.app.IOT.domain.repositories;

import com.nexusnova.lifetravelapi.app.IOT.domain.model.WeatherSensor;
import com.nexusnova.lifetravelapi.app.core.booking.domain.model.Booking;
import com.nexusnova.lifetravelapi.app.core.tours.domain.model.Destination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public interface WeatherSensorRepository extends JpaRepository<WeatherSensor, Long> {

    @Query("select b.tourPackage.id " +
            "from Booking b " +
            "where b._deleted=false and b.touristUser.id=:touristUserId and b.selectedDate>=:today")
    Optional<Long> findFirstBooking(@Param("today") Date today,
                                    @Param("touristUserId") String touristUserId);

    @Query("select d from Destination d where d._deleted=false and d.tourPackage.id=:packageId")
    List<Destination> findFirstWeatherSensor(@Param("packageId") Long packageId);
}
