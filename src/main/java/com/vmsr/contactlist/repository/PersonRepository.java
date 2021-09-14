package com.vmsr.contactlist.repository;

import com.vmsr.contactlist.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

    @Query(value = "select p from Person p where first_name like %?1%")
    List<Person> findByName(String name);

    @Query(value = "select p from Person p where email like %?1%")
    List<Person> findByEmail(String email);
}
