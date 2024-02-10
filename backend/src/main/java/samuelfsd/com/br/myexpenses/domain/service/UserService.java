package samuelfsd.com.br.myexpenses.domain.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import samuelfsd.com.br.myexpenses.domain.model.User;
import samuelfsd.com.br.myexpenses.domain.repository.UserRepository;
import samuelfsd.com.br.myexpenses.dto.User.UserRequestDTO;
import samuelfsd.com.br.myexpenses.dto.User.UserResponseDTO;

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

        //if(userOpt.isEmpty()) {}

        return mapper.map(userOpt.get(), UserResponseDTO.class);
    }

    @Override
    public UserResponseDTO create(UserRequestDTO dto) {
        // TODO
        return null;
    }

    @Override
    public UserResponseDTO update(Long id, UserRequestDTO dto) {
        // TODO
        return null;
    }

    @Override
    public void delete(Long id) {
        // TODO
    }
}
