package co.develhope.Interceptor_es2.cotrnollers;

import co.develhope.Interceptor_es2.entities.Month;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/months")
public class MonthController {
    // prendiamo la HttpServletRequest dall'interceptor come parametro per poi accedere al mese e restituirlo
    @GetMapping
    public ResponseEntity<Month> getMonth(HttpServletRequest request) {
        Month month = (Month) request.getAttribute("month");
        return ResponseEntity.ok(month);
    }
}
