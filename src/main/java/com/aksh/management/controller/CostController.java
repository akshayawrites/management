package com.aksh.management.controller;
import com.aksh.management.model.Cost;
import com.aksh.management.pojo.CostDTO;
import com.aksh.management.service.CostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cost")
public class CostController {

   final CostService costService;
    //@autowired
    public CostController(CostService costService) {
        this.costService = costService;
    }

    @GetMapping("/getall")
    public ResponseEntity<List<CostDTO>> getAll() {
        return new ResponseEntity<>(costService.getAllCost(), HttpStatus.OK);
    }

    @PostMapping(value  = "/create")
    public ResponseEntity<Cost> create(@RequestBody CostDTO cost) {
        Cost co=costService.saveCost(cost);
        return new ResponseEntity<>(co, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cost> getOne(@PathVariable Long id) {
        return new ResponseEntity<>(costService.getCostById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        costService.deleteCost(id);
        return new ResponseEntity<>("Deleted Successfully!", HttpStatus.OK);
    }
}
