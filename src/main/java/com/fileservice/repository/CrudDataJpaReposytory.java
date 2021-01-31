package com.fileservice.repository;

import com.fileservice.model.DataObject;
import org.springframework.stereotype.Repository;

/**
 * User: Vitaliy Klimov
 * Date: 22.01.2021
 */
@Repository
public class CrudDataJpaReposytory {
    private final CrudDataRepository dataRepository;

    public CrudDataJpaReposytory(CrudDataRepository crudDataRepository) {
        this.dataRepository = crudDataRepository;
    }

    public void save(DataObject dataObject) {
        dataRepository.save(dataObject);
    }
}
