package com.ssw.ist.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ssw.ist.model.StampCatalog;

@Repository
public interface StampCatalogRepository extends CrudRepository<StampCatalog, Integer> {

}
