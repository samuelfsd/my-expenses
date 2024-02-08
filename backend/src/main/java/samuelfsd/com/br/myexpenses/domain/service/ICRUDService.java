package samuelfsd.com.br.myexpenses.domain.service;

import java.util.List;

public interface ICRUDService<REQ,RES> {
    List<RES> getAll();
    RES getById(Long id);
    RES create(REQ dto);
    RES update(Long id, REQ dto);
    RES delete(Long id);
}
