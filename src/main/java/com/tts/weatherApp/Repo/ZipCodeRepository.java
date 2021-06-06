package com.tts.weatherApp.Repo;

import com.tts.weatherApp.Model.Request;
import com.tts.weatherApp.Model.Response;
import com.tts.weatherApp.Model.ZipCode;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ZipCodeRepository extends CrudRepository<ZipCode, Long> {

    @Query(value = "select ZIP_CODE from ZIP_CODE order by TIME_STAMP desc limit 10", nativeQuery = true)
    List<String> findRecentZips();
}
