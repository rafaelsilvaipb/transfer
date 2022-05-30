package br.com.cvc.transfer.controller;


import br.com.cvc.transfer.dto.TransferDTO;
import br.com.cvc.transfer.dto.TransferResponseDTO;
import br.com.cvc.transfer.mapper.TransferMapper;
import br.com.cvc.transfer.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/transfer")
@CrossOrigin(origins = "*")
public class TransferController {
    @Autowired
    private TransferService transferService;


    @PostMapping
    public ResponseEntity<TransferResponseDTO> save(@RequestBody TransferDTO transferDTO)  {
        return ResponseEntity.ok(TransferMapper.modelToResponse(
                                        transferService.save(
                                                TransferMapper.DTOToModel(transferDTO))));
    }


    @GetMapping
    public ResponseEntity<List<TransferResponseDTO>> listAll() {
        return ResponseEntity.ok(
                transferService.findAll()
                        .stream()
                        .map(c -> TransferMapper.modelToResponse(c))
                        .collect(Collectors.toList()));
    }

}
