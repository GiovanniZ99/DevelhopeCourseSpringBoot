package co.develhope.Interceptor_es2.interceptors;

import co.develhope.Interceptor_es2.entities.Month;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Component
public class MonthInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HashSet<Month> months = new HashSet<>();
        months.add(new Month(1, "January", "Gennaio","Januar"));
        months.add(new Month(2, "February", "Febbraio","Februar"));
        months.add(new Month(3, "March", "Marzo","März"));
        months.add(new Month(2, "April", "April","April"));
        months.add(new Month(2, "May", "Maggio","Mai"));
        months.add(new Month(2, "June", "Giugno","Juni"));
        String monthNumber = request.getHeader("monthNumber");
        if(monthNumber == null || monthNumber.isEmpty()){
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return false;
        }
        int MonthNumberInt = Integer.parseInt(monthNumber);
       Optional<Month> optionalMonth = months.stream().filter(month -> month.getMonthNumber()==MonthNumberInt).findAny();
       if(optionalMonth.isPresent()){
           request.setAttribute("month", optionalMonth.get());
       }else{
           request.setAttribute("month", new Month(1,"nope", "nope", "nope"));
       }
       response.setStatus(HttpServletResponse.SC_OK);
       return true;
    }
}
