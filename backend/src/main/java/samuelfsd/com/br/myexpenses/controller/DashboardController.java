package samuelfsd.com.br.myexpenses.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import samuelfsd.com.br.myexpenses.common.ApiPrefix;
import samuelfsd.com.br.myexpenses.domain.service.DashboardService;
import samuelfsd.com.br.myexpenses.dto.dashboard.DashboardResponseDTO;

@RestController
@RequestMapping(ApiPrefix.API_V1_PREFIX + "/dashboard")
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;

    public ResponseEntity<DashboardResponseDTO> getCashFlow (
            @RequestParam(name = "startDate") String startDate,
            @RequestParam(name = "endDate") String endDate
    ) {
        return ResponseEntity.ok(dashboardService.getCashFlow(startDate, endDate));
    }
}
