package samuelfsd.com.br.myexpenses.domain.service;

import samuelfsd.com.br.myexpenses.dto.User.UserRequestDTO;
import samuelfsd.com.br.myexpenses.dto.User.UserResponseDTO;

import java.util.List;

public class UserService implements ICRUDService<UserRequestDTO, UserResponseDTO>{
    @Override
    public List<UserResponseDTO> getAll() {
        // TODO
        return null;
    }

    @Override
    public UserResponseDTO getById(Long id) {
        // TODO
        return null;
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
