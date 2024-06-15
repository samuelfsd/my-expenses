package samuelfsd.com.br.myexpenses.controller;


import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import samuelfsd.com.br.myexpenses.common.ApiPrefix;
import samuelfsd.com.br.myexpenses.domain.exception.ResourceNotFoundException;
import samuelfsd.com.br.myexpenses.domain.model.User;
import samuelfsd.com.br.myexpenses.domain.repository.UserRepository;
import samuelfsd.com.br.myexpenses.dto.User.LoginRequestDTO;
import samuelfsd.com.br.myexpenses.dto.User.LoginResponseDTO;
import samuelfsd.com.br.myexpenses.dto.User.UserResponseDTO;
import samuelfsd.com.br.myexpenses.security.JwtService;

import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping(ApiPrefix.API_V1_PREFIX + "/auth")
public class AuthController {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    private final ModelMapper mapper;

    public AuthController(UserRepository repository, PasswordEncoder passwordEncoder, JwtService jwtService, ModelMapper mapper) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.mapper = mapper;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO dto) {
        User user = this.repository.findByEmail(dto.getEmail()).orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado um usuário com este email"));
        if(passwordEncoder.matches(dto.getPassword(), user.getPassword())) {
            String token = this.jwtService.generateToken(user);
            var responseDTO = mapper.map(user, UserResponseDTO.class);
            return ResponseEntity.ok(new LoginResponseDTO(token, responseDTO));
        }

        return ResponseEntity.badRequest().build();
    }


    @PostMapping("/register")
    public ResponseEntity<LoginResponseDTO> register(@RequestBody LoginRequestDTO dto) {
        Optional<User> user = this.repository.findByEmail(dto.getEmail());

        if (user.isEmpty()) {
            User newUser = new User();
            newUser.setPassword(passwordEncoder.encode(dto.getPassword()));
            newUser.setEmail(dto.getEmail());
            newUser.setCreatedAt(new Date());

            this.repository.save(newUser);
            String token = this.jwtService.generateToken(newUser);
            var responseDTO = mapper.map(newUser, UserResponseDTO.class);
            return ResponseEntity.ok(new LoginResponseDTO(token, responseDTO));
        }

        return ResponseEntity.badRequest().build();
    }
}
