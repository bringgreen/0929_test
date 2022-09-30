package com.jang.sample.repository;


import java.io.Serializable;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.enhanced.TableGenerator;

/**
 * AssignedTableGenerator - Assigned TableGenerator
 *
 * @author Vlad Mihalcea
 */
public class AssignedTableGenerator extends TableGenerator {

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object obj) {
        if(obj instanceof Identifiable) {
            Identifiable identifiable = (Identifiable) obj;
            Serializable id = identifiable.getId();
            if(id != null) {
                return id;
            }
        }
        return super.generate(session, obj);
    }
}