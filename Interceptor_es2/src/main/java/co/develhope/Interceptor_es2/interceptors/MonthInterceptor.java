package co.develhope.Interceptor_es2.interceptors;

import co.develhope.Interceptor_es2.entities.Month;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.HashSet;
import java.util.Optional;

@Component
public class MonthInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HashSet<Month> months = new HashSet<>();
        months.add(new Month(1, "January", "Gennaio","Januar"));
        months.add(new Month(2, "February", "Febbraio","Februar"));
        months.add(new Month(3, "March", "Marzo","März"));
        months.add(new Month(4, "April", "April","April"));
        months.add(new Month(5, "May", "Maggio","Mai"));
        months.add(new Month(6, "June", "Giugno","Juni"));
        String monthNumber = request.getHeader("monthNumber");
        if(monthNumber == null || monthNumber.isEmpty()){
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return false;
        }
        // dobbiamo convertire la stringa request in un int
        int MonthNumberInt = Integer.parseInt(monthNumber);
        // mediante la stream controlliamo se il numero passato alla request corrisponde a un numero di un mese
       Optional<Month> optionalMonth = months.stream().filter(month -> month.getMonthNumber()==MonthNumberInt).findAny();
       // se c'è settiamo la request con il mese che abbiamo trovato(per poi restituirla nel controller)
       if(optionalMonth.isPresent()){
           request.setAttribute("month", optionalMonth.get());
       }else{
           request.setAttribute("month", new Month(1,"nope", "nope", "nope"));
       }
       response.setStatus(HttpServletResponse.SC_OK);
       return true;
    }
}
