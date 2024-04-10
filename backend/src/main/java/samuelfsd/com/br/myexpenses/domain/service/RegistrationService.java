package samuelfsd.com.br.myexpenses.domain.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import samuelfsd.com.br.myexpenses.domain.exception.ResourceBadRequestException;
import samuelfsd.com.br.myexpenses.domain.exception.ResourceNotFoundException;
import samuelfsd.com.br.myexpenses.domain.model.Registration;
import samuelfsd.com.br.myexpenses.domain.model.User;
import samuelfsd.com.br.myexpenses.domain.repository.RegistrationRepository;
import samuelfsd.com.br.myexpenses.dto.Registration.RegistrationRequestDTO;
import samuelfsd.com.br.myexpenses.dto.Registration.RegistrationResponseDTO;

import java.util.Date;
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
        validateRegistration(dto);

        Registration registration = mapper.map(dto, Registration.class);

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        registration.setUser(user);
        registration.setId(null);
        registration.setCreated_at(new Date());

        registration = registrationRepository.save(registration);

        return mapper.map(registration, RegistrationResponseDTO.class);
    }

    @Override
    public RegistrationResponseDTO update(Long id, RegistrationRequestDTO dto) {
        getById(id);
        validateRegistration(dto);

        Registration registration = mapper.map(dto, Registration.class);

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        registration.setUser(user);
        registration.setId(id);

        registration = registrationRepository.save(registration);

        return mapper.map(registration, RegistrationResponseDTO.class);

    }

    @Override
    public void delete(Long id) {
        getById(id);

        registrationRepository.deleteById(id);
    }

    public List<RegistrationResponseDTO> getByExpirationDate(String startDate, String endDate) {
        List<Registration> registrations = registrationRepository.getCashFlowByExpirationDate(startDate, endDate);

        return registrations.stream()
                .map(registration -> mapper.map(registration, RegistrationResponseDTO.class))
                .collect(Collectors.toList());
    }

    private void validateRegistration (RegistrationRequestDTO dto) {
        if (dto.getType() == null ||
            dto.getExpiration_date() == null ||
            dto.getValue() == null ||
            dto.getDescription() == null
        ) {
            throw new ResourceBadRequestException("Os campos de tipo, data de vencimento, valor e descrição são obrigatórios.");
        }
    }
}
