package samuelfsd.com.br.myexpenses.domain.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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

public class UserService implements ICRUDService<UserRequestDTO, UserResponseDTO>{

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private UserRepository userRepository;
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
        validateUser(dto);

        User user = mapper.map(dto, User.class);

        // crypt password

        // save user
        user.setId(null);
        userRepository.save(user);

        return mapper.map(user, UserResponseDTO.class);
    }

    @Override
    public UserResponseDTO update(Long id, UserRequestDTO dto) {
        UserResponseDTO useRes = getById(id);
        validateUser(dto);

        User user = mapper.map(dto, User.class);

        user.setId(id);
        user.setDateInactivation(useRes.getDateInactivation());
        userRepository.save(user);

        return mapper.map(user, UserResponseDTO.class);
    }

    @Override
    public void delete(Long id) {
        UserResponseDTO userRes = getById(id);

        User user = mapper.map(userRes, User.class);
        user.setDateInactivation(new Date());

        userRepository.save(user);
    }

    private void validateUser(UserRequestDTO dto){
        if(dto.getEmail() == null || dto.getPassword() == null) {
            throw new ResourceBadRequestException("E-mail e senha são obrigatórios!");
        }
    }
}
