package com.ahmetyildiran.enoca.general;


import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


//E is Customer entity
// R ropository
@Service
@RequiredArgsConstructor
public abstract class BaseEntityService<E extends BaseEntity,R extends JpaRepository<E,Long>> {

    private final R ropository;
    public E save(E entity){

        BaseAdditionalFields baseAdditionalFields = entity.getBaseAdditionalFields();

        if (baseAdditionalFields == null) {
            baseAdditionalFields = new BaseAdditionalFields();
          }

        if (entity.getId()  == null){
            baseAdditionalFields.setCreatedDate(LocalDateTime.now());
            //baseAdditionalFields.setCreatedBy(0L); // TODO: JWT olsaydı oradan alacaktık
        }

        baseAdditionalFields.setUpdatedDate(LocalDateTime.now());
        //baseAdditionalFields.setUpdatedBy(0L);// TODO: JWT olsaydı oradan alacaktık

        entity.setBaseAdditionalFields(baseAdditionalFields);
        entity = ropository.save(entity);

        return entity;
    }

    public List<E> findAll() {
        return ropository.findAll();
    }

    public void delete(Long id){
        ropository.deleteById(id);
    }

    public void delete(E entity){
        ropository.delete(entity);
    }

    public Optional<E> findById(Long id){
        return ropository.findById(id);
    }
    public E findByIdWithControl(Long id){
        return ropository.findById(id).orElseThrow();
    }

    public boolean isExist(Long id){
        return ropository.existsById(id);
    }
}
