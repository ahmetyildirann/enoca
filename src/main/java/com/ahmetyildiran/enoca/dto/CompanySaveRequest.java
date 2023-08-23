package com.ahmetyildiran.enoca.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanySaveRequest {
    private String name;
    private String address;
    private String email;
}
