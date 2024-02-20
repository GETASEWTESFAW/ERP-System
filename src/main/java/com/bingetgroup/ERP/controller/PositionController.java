package com.bingetgroup.ERP.controller;

import com.bingetgroup.ERP.dto.Allowance;
import com.bingetgroup.ERP.dto.Employee;
import com.bingetgroup.ERP.dto.Position;
import com.bingetgroup.ERP.models.Positions;
import com.bingetgroup.ERP.services.AllowanceService;
import com.bingetgroup.ERP.services.PositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*/*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/hr")
public class PositionController {
    private final PositionService positionService;
    @PostMapping("/registerPosition")
    public ResponseEntity<String> register(@RequestBody Position position){
        return new ResponseEntity<>(this.positionService.add(position), HttpStatus.OK);
    }

    @PutMapping("/updatePosition")
    public ResponseEntity<String> update(@RequestBody Position position){
        return new ResponseEntity<>(this.positionService.update(position), HttpStatus.OK);
    }
    @DeleteMapping("/deletePosition/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") String id){
        return new ResponseEntity<>(this.positionService.delete(id), HttpStatus.OK);
    }
    @GetMapping("/getPosition")
    public ResponseEntity<List<Positions>> getPositions(@RequestParam(value = "page",defaultValue = "1") String page, @RequestParam(value = "size",defaultValue = "10") String size, @RequestParam(value = "column",defaultValue = "positionName") String column){
        int pages=Integer.parseInt(page);
        int sizes=Integer.parseInt(size);
        return new ResponseEntity<>(this.positionService.getAllPosition(pages,sizes,column), HttpStatus.OK);
    }
}
