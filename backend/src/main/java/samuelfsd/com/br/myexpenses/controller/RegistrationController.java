
package samuelfsd.com.br.myexpenses.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import samuelfsd.com.br.myexpenses.common.ApiPrefix;
import samuelfsd.com.br.myexpenses.domain.service.RegistrationService;
import samuelfsd.com.br.myexpenses.dto.Registration.RegistrationRequestDTO;
import samuelfsd.com.br.myexpenses.dto.Registration.RegistrationResponseDTO;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(ApiPrefix.API_V1_PREFIX + "/registrations")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;


    @GetMapping
    public ResponseEntity<List<RegistrationResponseDTO>> getAll(){
        return ResponseEntity.ok(registrationService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegistrationResponseDTO> getById(@PathVariable Long id){
        return ResponseEntity.ok(registrationService.getById(id));
    }

    @PostMapping
    public ResponseEntity<RegistrationResponseDTO> create(@RequestBody RegistrationRequestDTO dto){
        RegistrationResponseDTO registration = registrationService.create(dto);
        return new ResponseEntity<>(registration, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RegistrationResponseDTO> update(@PathVariable Long id, @RequestBody RegistrationRequestDTO dto){
        return ResponseEntity.ok(registrationService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        registrationService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
