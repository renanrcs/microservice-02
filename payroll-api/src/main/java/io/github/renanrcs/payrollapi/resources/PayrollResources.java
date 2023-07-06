package io.github.renanrcs.payrollapi.resources;

import io.github.renanrcs.payrollapi.domain.Payroll;
import io.github.renanrcs.payrollapi.domain.User;
import io.github.renanrcs.payrollapi.feignClientes.UserFeign;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "api/payments")
public class PayrollResources {

    private final UserFeign userFeign;

    @GetMapping(value = "/{workerId}")
    public ResponseEntity<Payroll> getPayment(@PathVariable Long workerId, @RequestBody Payroll payment){

        User user = userFeign.findById(workerId).getBody();

        return ResponseEntity.ok().body(
                new Payroll(
                        user.getName(),
                        payment.getDescription(),
                        user.getHourlyPrice(),
                        payment.getWorkedHours(),
                        user.getHourlyPrice() * payment.getWorkedHours()
                        )
        );
    }
}
