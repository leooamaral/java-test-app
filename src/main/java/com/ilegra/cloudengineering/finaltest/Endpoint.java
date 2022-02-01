package com.ilegra.cloudengineering.finaltest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import static java.util.stream.Collectors.toCollection;

@RestController
public class Endpoint {
    private Map<String, Employee> fakeDataStore =  new HashMap<>();

    @GetMapping("/employees/{id}")
    ResponseEntity<Employee> findById(@PathVariable String id) {
        Map<String, Employee> dataStore = Optional.ofNullable(fakeDataStore).orElse(new HashMap<>());

        return  (dataStore.containsKey(id)) ?  new ResponseEntity<Employee>(dataStore.get(id), HttpStatus.OK) : new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/employees")
    List<Employee> employeeList() {
        return Optional
                .ofNullable(fakeDataStore)
                .orElse(new HashMap<>())
                .values()
                .stream()
                .collect(toCollection(ArrayList::new));
    }

    @PutMapping("/employees")
    String save(@RequestBody Employee employee) {
        String id  =  UUID.randomUUID().toString();
        employee.setId(id);
        fakeDataStore.put(id, employee);

        return id;
    }

}
