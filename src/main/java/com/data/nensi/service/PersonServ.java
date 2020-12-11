
package com.data.nensi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonServ {

    private final PersonDataAccessService PersonDataAccessService;
    
    @Autowired
    public PersonService(PersonDataAccessService PersonDataAccessService,

    List<Person> getAllPersons() {
        return PersonDataAccessService.selectAllPersons();
    }

    void addNewPerson(Person Person) {
        addNewPerson(null, Person);
    }

    void addNewPerson(UUID PersonId, Person Person) {
        UUID newPersonId = Optional.ofNullable(PersonId)
                .orElse(UUID.randomUUID());
      
        PersonDataAccessService.insertPerson(newPersonId, Person);
    }

    List<PersonCourse> getAllCoursesForPerson(UUID PersonId) {
        return PersonDataAccessService.selectAllPersonCourses(PersonId);
    }

    public void updatePerson(UUID PersonId, Person Person) {
       
        Optional.ofNullable(Person.getName())
                .filter(Name -> !StringUtils.isEmpty(Name))
                .map(StringUtils::capitalize)
                .ifPresent(Name -> PersonDataAccessService.updateName(PersonId, Name));

   
    }

    void deletePerson(UUID PersonId) {
        PersonDataAccessService.deletePersonById(PersonId);
    }
}
