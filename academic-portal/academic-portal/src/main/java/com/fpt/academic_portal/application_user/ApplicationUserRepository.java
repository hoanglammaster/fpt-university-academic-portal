package com.fpt.academic_portal.application_user;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ApplicationUserRepository extends MongoRepository<ApplicationUser, UUID> {

    Optional<ApplicationUser> findApplicationUserByUsername(String username);
}
