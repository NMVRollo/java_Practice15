package com.example.Practice15.controller;

import com.example.Practice15.dao.ManufactureDao;
import com.example.Practice15.model.Manufacture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manufacture")
public class ManufactureController {

    @Autowired
    ManufactureDao dao;

    @GetMapping
    public List<Manufacture> getAll() {
        return dao.getManufactures();
    }

    @PostMapping
    public void save(@RequestBody Manufacture manufacture) {
        dao.addManufacture(manufacture);
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable("id") Long id) {
        dao.removeManufacture(id);
    }

}
