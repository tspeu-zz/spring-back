package com.jmb.repository;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.jmb.entity.ContactEntity;

@Repository("contactRepository")
public interface ContactRepository extends JpaRepository<ContactEntity , Serializable> {

}
