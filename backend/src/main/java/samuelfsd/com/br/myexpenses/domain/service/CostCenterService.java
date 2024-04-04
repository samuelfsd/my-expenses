package samuelfsd.com.br.myexpenses.domain.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import samuelfsd.com.br.myexpenses.domain.exception.ResourceNotFoundException;
import samuelfsd.com.br.myexpenses.domain.model.CostCenter;
import samuelfsd.com.br.myexpenses.domain.model.User;
import samuelfsd.com.br.myexpenses.domain.repository.CostCenterRepository;
import samuelfsd.com.br.myexpenses.dto.CostCenter.CostCenterRequestDTO;
import samuelfsd.com.br.myexpenses.dto.CostCenter.CostCenterResponseDTO;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CostCenterService implements ICRUDService<CostCenterRequestDTO, CostCenterResponseDTO> {

    @Autowired
    private CostCenterRepository costCenterRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public List<CostCenterResponseDTO> getAll() {
        List<CostCenter> costCenters = costCenterRepository.findAll();

        return costCenters.stream()
                .map(costCenter -> mapper.map(costCenter, CostCenterResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public CostCenterResponseDTO getById(Long id) {
        Optional<CostCenter> costCenter = costCenterRepository.findById(id);

        if (costCenter.isEmpty()) {
            throw new ResourceNotFoundException("Não foi encontrado um centro de custo com este id " + id);
        }

        return mapper.map(costCenter.get(), CostCenterResponseDTO.class);
    }

    @Override
    public CostCenterResponseDTO create(CostCenterRequestDTO dto) {
        CostCenter costCenter = mapper.map(dto, CostCenter.class);

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        costCenter.setUser(user);
        costCenter.setId(null);

        costCenter = costCenterRepository.save(costCenter);

        return mapper.map(costCenter, CostCenterResponseDTO.class);
    }

    @Override
    public CostCenterResponseDTO update(Long id, CostCenterRequestDTO dto) {
        getById(id);

        CostCenter costCenter = mapper.map(dto, CostCenter.class);

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        costCenter.setUser(user);
        costCenter.setId(id);

        costCenter = costCenterRepository.save(costCenter);

        return mapper.map(costCenter, CostCenterResponseDTO.class);
    }

    @Override
    public void delete(Long id) {
        getById(id);

        costCenterRepository.deleteById(id);

    }
}
