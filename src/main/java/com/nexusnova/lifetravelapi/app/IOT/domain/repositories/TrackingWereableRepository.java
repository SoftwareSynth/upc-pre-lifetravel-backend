package com.nexusnova.lifetravelapi.app.IOT.domain.repositories;

import com.nexusnova.lifetravelapi.app.IOT.domain.model.TrackingWearable;
import com.nexusnova.lifetravelapi.app.core.booking.domain.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface TrackingWereableRepository extends JpaRepository<TrackingWearable, Long> {

    @Query("select b.touristUser.id " +
            "from Booking b " +
            "where b._deleted=false and b.tourPackage.id=:packageId and b.selectedDate between :yesterday and :tomorrow")
    List<String> findUsersofDay(@Param("yesterday") Date yesterday,
                                @Param("tomorrow") Date tomorrow,
                                @Param("packageId") Long packageId);

    @Query("SELECT b.tourPackage.id " +
            "FROM Booking b " +
            "WHERE b._deleted = false AND b.agencyUser.id = :agencyUserId AND b.selectedDate >= :today " +
            "ORDER BY b.selectedDate ASC")
    List<Long> findFirstBooking(@Param("today") Date today,
                                    @Param("agencyUserId") String agencyUserId);


    @Query("select b " +
            "from TrackingWearable b " +
            "where b._deleted=false and b.touristUser.id=:touristUserId")
    TrackingWearable findGPS(@Param("touristUserId") String touristUserId);
}
