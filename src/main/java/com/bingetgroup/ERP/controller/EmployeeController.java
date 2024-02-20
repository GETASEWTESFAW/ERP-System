package com.bingetgroup.ERP.controller;


import com.bingetgroup.ERP.dto.Employee;
import com.bingetgroup.ERP.models.Employees;
import com.bingetgroup.ERP.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*/*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/hr")
public class EmployeeController {
    private final EmployeeService employeeService;
    @PostMapping("/registerEmployee")
    public ResponseEntity<String> register(@RequestBody Employee employee){
        return new ResponseEntity<>(this.employeeService.add(employee), HttpStatus.OK);
    }
    @PutMapping("/updateEmployee")
    public ResponseEntity<String> update(@RequestBody Employee employee){
        return new ResponseEntity<>(this.employeeService.update(employee), HttpStatus.OK);
    }
    @DeleteMapping("/deleteEmployee/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") String id){
        return new ResponseEntity<>(this.employeeService.delete(id), HttpStatus.OK);
    }
    @GetMapping("/getEmployee/{id}")
    public ResponseEntity<Employees> getEmployeeById(@PathVariable("id") String id){
        return new ResponseEntity<>(this.employeeService.getEmployeeById(Long.parseLong(id)), HttpStatus.OK);
    }
    @GetMapping("/getAllEmployee")
    public ResponseEntity<List<Employees>> getEmployee(@RequestParam(value = "page",defaultValue = "1") String page, @RequestParam(value = "size",defaultValue = "10") String size, @RequestParam(value = "column",defaultValue = "fullName") String column){
        int pages=Integer.parseInt(page);
        int sizes=Integer.parseInt(size);
        return new ResponseEntity<>(this.employeeService.getAllEmployees(pages,sizes,column), HttpStatus.OK);
    }
}
