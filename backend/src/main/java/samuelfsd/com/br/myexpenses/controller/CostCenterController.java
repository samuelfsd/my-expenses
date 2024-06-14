package samuelfsd.com.br.myexpenses.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import samuelfsd.com.br.myexpenses.common.ApiPrefix;
import samuelfsd.com.br.myexpenses.domain.service.CostCenterService;
import samuelfsd.com.br.myexpenses.dto.CostCenter.CostCenterRequestDTO;
import samuelfsd.com.br.myexpenses.dto.CostCenter.CostCenterResponseDTO;

import java.util.List;

@RestController
@RequestMapping(ApiPrefix.API_V1_PREFIX + "/cost-centers")
public class CostCenterController {

    @Autowired
    private CostCenterService costCenterService;

    @GetMapping
    public ResponseEntity<List<CostCenterResponseDTO>> listAll() {
        return ResponseEntity.ok(costCenterService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CostCenterResponseDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(costCenterService.getById(id));
    }

    @PostMapping
    public ResponseEntity<CostCenterResponseDTO> create(@RequestBody CostCenterRequestDTO dto) {
        CostCenterResponseDTO response = costCenterService.create(dto);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CostCenterResponseDTO> update(@PathVariable Long id, @RequestBody CostCenterRequestDTO dto) {
        return ResponseEntity.ok(costCenterService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        costCenterService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
