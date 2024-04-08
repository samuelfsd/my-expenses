package samuelfsd.com.br.myexpenses.domain.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import samuelfsd.com.br.myexpenses.domain.model.Registration;
import samuelfsd.com.br.myexpenses.domain.repository.RegistrationRepository;
import samuelfsd.com.br.myexpenses.dto.Registration.RegistrationRequestDTO;
import samuelfsd.com.br.myexpenses.dto.Registration.RegistrationResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RegistrationService implements ICRUDService<RegistrationRequestDTO, RegistrationResponseDTO> {

    @Autowired
    private RegistrationRepository registrationRepository;

    @Autowired
    private ModelMapper mapper;
    @Override
    public List<RegistrationResponseDTO> getAll() {
       List<Registration> registrations = registrationRepository.findAll();

       return registrations.stream().map(registration -> mapper.map(registration, RegistrationResponseDTO.class))
               .collect(Collectors.toList());
    }

    @Override
    public RegistrationResponseDTO getById(Long id) {
        return null;
    }

    @Override
    public RegistrationResponseDTO create(RegistrationRequestDTO dto) {
        return null;
    }

    @Override
    public RegistrationResponseDTO update(Long id, RegistrationRequestDTO dto) {
        return null;
    }
a
    @Override
    public void delete(Long id) {

    }
}
