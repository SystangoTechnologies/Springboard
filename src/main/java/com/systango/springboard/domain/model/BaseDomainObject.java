package com.systango.springboard.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

/**
 * Represents all common properties of standard domain objects
 *
 * @author Arpit Khandelwal
 */
@MappedSuperclass
@Setter
@Getter
@NoArgsConstructor
public class BaseDomainObject implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @CreationTimestamp
    protected Date createTimestamp = new Date();

    @UpdateTimestamp
    protected Date lastEditTimestamp;
}
