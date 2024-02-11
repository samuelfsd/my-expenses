package samuelfsd.com.br.myexpenses.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import samuelfsd.com.br.myexpenses.domain.service.UserService;
import samuelfsd.com.br.myexpenses.dto.User.UserDTO;
import samuelfsd.com.br.myexpenses.dto.User.UserRequestDTO;
import samuelfsd.com.br.myexpenses.dto.User.UserResponseDTO;

import javax.swing.text.rtf.RTFEditorKit;
import java.net.URI;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAll(){
        return ResponseEntity.ok(userService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getById(@PathVariable Long id){
        return ResponseEntity.ok(userService.getById(id));
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> create(@RequestParam UserRequestDTO dto){
        UserResponseDTO user = userService.create(dto);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDTO> update(@PathVariable Long id,@RequestParam UserRequestDTO dto){
        UserResponseDTO user = userService.update(id, dto);

        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        userService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
