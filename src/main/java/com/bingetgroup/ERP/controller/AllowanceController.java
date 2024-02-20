package com.bingetgroup.ERP.controller;

import com.bingetgroup.ERP.dto.Allowance;
import com.bingetgroup.ERP.models.Allowances;
import com.bingetgroup.ERP.services.AllowanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*/*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/hr")
public class AllowanceController {
    private final AllowanceService allowanceService;

    @PostMapping("/registerAllowance")
     public ResponseEntity<String> register(@RequestBody Allowance allowance){
         return new ResponseEntity<>(this.allowanceService.add(allowance), HttpStatus.OK);
     }
    @PutMapping("/updateAllowance")
    public ResponseEntity<String> update(@RequestBody Allowance allowance){
        return new ResponseEntity<>(this.allowanceService.update(allowance), HttpStatus.OK);
    }
    @DeleteMapping("/deleteAllowance/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") String id){
        return new ResponseEntity<>(this.allowanceService.delete(id), HttpStatus.OK);
    }
    @GetMapping("/getAllAllowance")
    public ResponseEntity<List<Allowances>> getAllowance(@RequestParam(value = "page",defaultValue = "1") String page, @RequestParam(value = "size",defaultValue = "10") String size, @RequestParam(value = "column",defaultValue = "allowanceType") String column){
        int pages=Integer.parseInt(page);
        int sizes=Integer.parseInt(size);
        return new ResponseEntity<>(this.allowanceService.getAllAllowance(pages,sizes,column), HttpStatus.OK);
    }
}
