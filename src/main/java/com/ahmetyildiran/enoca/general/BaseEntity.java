package com.ahmetyildiran.enoca.general;

import jakarta.persistence.Embedded;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@MappedSuperclass // bunu etiketlemezsek kodun bi yerinde oluşturmaya çalışıyor
public abstract class BaseEntity implements Serializable, Cloneable, BaseEntityModel{

    @Embedded
    private BaseAdditionalFields baseAdditionalFields;
}
