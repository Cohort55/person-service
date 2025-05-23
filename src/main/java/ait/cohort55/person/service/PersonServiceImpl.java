package ait.cohort55.person.service;

import ait.cohort55.person.dao.PersonRepository;
import ait.cohort55.person.dto.AddressDto;
import ait.cohort55.person.dto.CityPopulationDto;
import ait.cohort55.person.dto.PersonDto;
import ait.cohort55.person.dto.exception.ConflictException;
import ait.cohort55.person.dto.exception.NotFoundException;
import ait.cohort55.person.model.Person;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;
    private final ModelMapper modelMapper;

    @Transactional
    @Override
    public void addPerson(PersonDto personDto) {
        if (personRepository.existsById(personDto.getId())) {
            throw new ConflictException("Person with id " + personDto.getId() + " already exists");
        }
        personRepository.save(modelMapper.map(personDto, Person.class));
    }

    @Override
    public PersonDto getPersonById(Integer id) {
        Person person = personRepository.findById(id).orElseThrow(NotFoundException::new);
        return modelMapper.map(person, PersonDto.class);
    }

    @Override
    public PersonDto deletePersonById(Integer id) {
        return null;
    }

    @Override
    public PersonDto updatePersonName(Integer id, String name) {
        return null;
    }

    @Override
    public PersonDto updatePersonAddress(Integer id, AddressDto addressDto) {
        return null;
    }

    @Override
    public PersonDto[] findPersonsByName(String name) {
        return new PersonDto[0];
    }

    @Override
    public PersonDto[] findPersonsByCity(String city) {
        return new PersonDto[0];
    }

    @Override
    public PersonDto[] findPersonsBetweenAge(Integer minAge, Integer maxAge) {
        return new PersonDto[0];
    }

    @Override
    public Iterable<CityPopulationDto> getCitiesPopulation() {
        return null;
    }
}
