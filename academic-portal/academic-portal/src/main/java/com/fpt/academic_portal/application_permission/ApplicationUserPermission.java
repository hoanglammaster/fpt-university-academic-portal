package com.fpt.academic_portal.application_permission;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "user_permission")
@Data
public class ApplicationUserPermission {

    @Field("_id")
    private Integer id;
    private String permission;
}
