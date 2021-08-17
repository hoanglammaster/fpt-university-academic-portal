package com.fpt.academic_portal.application_role;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;
import java.util.Set;

@Document("user_role")
@Data
public class ApplicationUserRole {

    @Field("_id")
    private final Integer id;
    @Field("role")
    private final String role;
    @Field("permission")
    private final Set<Integer> permission;

}
