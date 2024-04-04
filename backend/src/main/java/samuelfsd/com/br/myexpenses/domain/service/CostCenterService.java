package samuelfsd.com.br.myexpenses.domain.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import samuelfsd.com.br.myexpenses.domain.model.CostCenter;
import samuelfsd.com.br.myexpenses.domain.repository.CostCenterRepository;
import samuelfsd.com.br.myexpenses.dto.CostCenter.CostCenterRequestDTO;
import samuelfsd.com.br.myexpenses.dto.CostCenter.CostCenterResponseDTO;

import java.util.List;
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
        return null;
    }

    @Override
    public CostCenterResponseDTO create(CostCenterRequestDTO dto) {
        return null;
    }

    @Override
    public CostCenterResponseDTO update(Long id, CostCenterRequestDTO dto) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
