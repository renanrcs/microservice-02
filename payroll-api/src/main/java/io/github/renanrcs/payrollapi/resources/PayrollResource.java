package io.github.renanrcs.payrollapi.resources;

import io.github.renanrcs.payrollapi.domain.Payroll;
import io.github.renanrcs.payrollapi.services.PayrollService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "api/payments")
public class PayrollResource {

    private final PayrollService payrollService;

    @GetMapping(value = "/{workerId}")
    public ResponseEntity<Payroll> getPayment(@PathVariable Long workerId, @RequestBody Payroll payment){
        return ResponseEntity.ok().body(
                payrollService.getPayment(workerId, payment)
        );
    }
}
