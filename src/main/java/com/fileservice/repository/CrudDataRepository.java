package com.fileservice.repository;
import com.fileservice.model.DataObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


/**
 * User: Vitaliy Klimov
 * Date: 22.01.2021
 */
@Transactional(readOnly = true)
public interface CrudDataRepository extends JpaRepository<DataObject, Integer> {

    @Transactional
    @Modifying
    @Query("DELETE FROM DataObject d WHERE d.id=:id")
    int delete(@Param("id") int id);
}
