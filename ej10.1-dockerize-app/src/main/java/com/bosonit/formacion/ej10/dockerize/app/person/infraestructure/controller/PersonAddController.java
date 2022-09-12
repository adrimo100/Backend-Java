package com.bosonit.formacion.ej10.dockerize.app.person.infraestructure.controller;

import com.bosonit.formacion.ej10.dockerize.app.person.application.PersonService;
import com.bosonit.formacion.ej10.dockerize.app.person.application.PersonServiceImp;
import com.bosonit.formacion.ej10.dockerize.app.person.infraestructure.controller.input.PersonInputDto;
import com.bosonit.formacion.ej10.dockerize.app.person.infraestructure.controller.output.PersonOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonAddController {

    @Autowired
    PersonServiceImp personServiceImp;

    @PostMapping("/person")
    public PersonOutputDto addPerson(@RequestBody PersonInputDto personInputDto) throws Exception {
            return personServiceImp.addPerson(personInputDto);
    }
}
