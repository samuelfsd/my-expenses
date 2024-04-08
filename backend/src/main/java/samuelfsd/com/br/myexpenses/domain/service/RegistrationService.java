package samuelfsd.com.br.myexpenses.domain.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import samuelfsd.com.br.myexpenses.domain.exception.ResourceNotFoundException;
import samuelfsd.com.br.myexpenses.domain.model.Registration;
import samuelfsd.com.br.myexpenses.domain.repository.RegistrationRepository;
import samuelfsd.com.br.myexpenses.dto.Registration.RegistrationRequestDTO;
import samuelfsd.com.br.myexpenses.dto.Registration.RegistrationResponseDTO;

import java.util.List;
import java.util.Optional;
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
        Optional<Registration> registrationOpt = registrationRepository.findById(id);

        if (registrationOpt.isEmpty()) {
            throw new ResourceNotFoundException("Não foi encontrado nenhum Título com este ID" + id);
        }

        return mapper.map(registrationOpt.get(), RegistrationResponseDTO.class);
    }

    @Override
    public RegistrationResponseDTO create(RegistrationRequestDTO dto) {
        return null;
    }

    @Override
    public RegistrationResponseDTO update(Long id, RegistrationRequestDTO dto) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
