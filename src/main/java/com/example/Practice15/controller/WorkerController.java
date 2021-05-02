package com.example.Practice15.controller;

import com.example.Practice15.dao.WorkerDao;
import com.example.Practice15.model.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/worker")
public class WorkerController {

    @Autowired
    WorkerDao dao;

    @GetMapping
    public List<Worker> getAll() {
        return dao.getWorkers();
    }

    @PostMapping
    public void save(@RequestBody Worker worker) {
        dao.addWorker(worker);
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable("id") Long id) {
        dao.removeWorker(id);
    }

}
