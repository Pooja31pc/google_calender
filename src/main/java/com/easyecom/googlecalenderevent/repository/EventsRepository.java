package com.easyecom.googlecalenderevent.repository;

import com.easyecom.googlecalenderevent.model.Events;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

@Repository
public interface EventsRepository extends JpaRepository<Events, Long> {

    @Query("select d from Events d where d.user.email=:email and d.startTime >= :currentTime order by d.startTime")
    List<Events> findByUserEmail(@Param("email") String email, @Param("currentTime") Date currentTime);

}
