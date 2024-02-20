package com.bingetgroup.ERP.services;

import com.bingetgroup.ERP.dto.Position;
import com.bingetgroup.ERP.exception.RecordNotFoundException;
import com.bingetgroup.ERP.models.Allowances;
import com.bingetgroup.ERP.models.Positions;
import com.bingetgroup.ERP.repositories.PositionsRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PositionService {
    private final PositionsRepository positionsRepository;
    private final AllowanceService allowanceService;
    public Positions getPositionById(Long id){
        return this.positionsRepository.findById(id).orElseThrow(()->new RecordNotFoundException("Position is not found."));
    }
    public List<Positions> getAllPosition(int page, int size, String column){
        Sort sort= Sort.by(column).ascending();
        Pageable pageable=PageRequest.of(page,size,sort);
        return this.positionsRepository.findAll(pageable).getContent();
    }

    public String add(Position position){
          List<Allowances> allowances=position.
                                    getAllowanceIds().stream().map((alId)->{
                                    return  this.allowanceService.getAllowanceById(Long.parseLong(alId));
                  }).toList();
          Positions positions=new Positions();
          positions.setPositionName(position.getPositionName());
          positions.setAllowance(allowances);
          this.positionsRepository.save(positions);
        //add position
        return "Position is recorded successfully";
    }
    public String update(Position position){
        Positions positions=getPositionById(Long.parseLong(position.getId()));
        List<Allowances> allowances=position.
                getAllowanceIds().stream().map((alId)->{
                    return  this.allowanceService.getAllowanceById(Long.parseLong(alId));
                }).toList();

        positions.setPositionName(position.getPositionName());
        positions.setAllowance(allowances);
        this.positionsRepository.save(positions);
        return "Position is updated successfully";
    }
    public String delete(Positions positions){
        this.positionsRepository.delete(positions);
        return "Position is deleted successfully";
    }
    public String delete(String positionId){
        this.positionsRepository.deleteById(Long.parseLong(positionId));
        return "Position is deleted successfully";
    }


}
