package samuelfsd.com.br.myexpenses.domain.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import samuelfsd.com.br.myexpenses.domain.exception.ResourceBadRequestException;
import samuelfsd.com.br.myexpenses.domain.exception.ResourceNotFoundException;
import samuelfsd.com.br.myexpenses.domain.model.User;
import samuelfsd.com.br.myexpenses.domain.repository.UserRepository;
import samuelfsd.com.br.myexpenses.dto.User.UserRequestDTO;
import samuelfsd.com.br.myexpenses.dto.User.UserResponseDTO;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService implements ICRUDService<UserRequestDTO, UserResponseDTO>{

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<UserResponseDTO> getAll() {
       List<User> users = userRepository.findAll();

        return users.stream()
                .map(user -> mapper.map(user, UserResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserResponseDTO getById(Long id) {
        Optional<User> userOpt = userRepository.findById(id);

        if(userOpt.isEmpty()) {
            throw new ResourceNotFoundException("Não foi possível encontrar o usuário com o id: " + id);
        }

        return mapper.map(userOpt.get(), UserResponseDTO.class);
    }

    @Override
    public UserResponseDTO create(UserRequestDTO dto) {
        return null;
    }

    public UserResponseDTO getByEmail(String email) {
        Optional<User> userOpt = userRepository.findByEmail(email);

        if(userOpt.isEmpty()) {
            throw new ResourceNotFoundException("Não foi possível encontrar o usuário com o email: " + email);
        }

        return mapper.map(userOpt.get(), UserResponseDTO.class);
    }

    @Override
    public UserResponseDTO update(Long id, UserRequestDTO dto) {
        UserResponseDTO useRes = getById(id);
        validateUser(dto);

        User user = mapper.map(dto, User.class);

        String password = passwordEncoder.encode(dto.getPassword());

        user.setId(null);
        user.setPassword(password);
        user.setDateInactivation(useRes.getDateInactivation());
        user.setCreatedAt(useRes.getCreated_at());
        userRepository.save(user);

        return mapper.map(user, UserResponseDTO.class);
    }

    @Override
    public void delete(Long id) {
        Optional<User> userOpt = userRepository.findById(id);

        if(userOpt.isEmpty()) {
            throw new ResourceNotFoundException("Não foi possível encontrar o usuário com o id: " + id);
        }

        User user = userOpt.get();
        user.setDateInactivation(new Date());

        userRepository.delete(user);
    }

    private void validateUser(UserRequestDTO dto){
        if(dto.getEmail() == null || dto.getPassword() == null) {
            throw new ResourceBadRequestException("E-mail e senha são obrigatórios!");
        }
    }
}
