package com.fpt.academic_portal.application_permission;

import org.springframework.data.mongodb.core.aggregation.ArrayOperators;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface ApplicationUserPermissionRepository extends MongoRepository<ApplicationUserPermission,Integer> {

    Set<ApplicationUserPermission> findApplicationUserPermissionsByIdIsIn(Set<Integer> listIds);
}
