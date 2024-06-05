package co.develhope.Interceptor_es2.cotrnollers;

import co.develhope.Interceptor_es2.entities.Month;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/months")
public class MonthController {
    @Autowired
    private Month month;

    @GetMapping
    public ResponseEntity<Month> getMonth(@RequestParam int monthNumber){
        switch (monthNumber) {
            case 1:
                month.setMonthNumber(1);
                month.setEnglishName("January");
                month.setItalianName("Gennaio");
                month.setGermanName("Januar");
                break;
            case 2:
                month.setMonthNumber(2);
                month.setEnglishName("February");
                month.setItalianName("Febbraio");
                month.setGermanName("Februar");
                break;
            case 3:
                month.setMonthNumber(3);
                month.setEnglishName("March");
                month.setItalianName("Marzo");
                month.setGermanName("März");
                break;
            case 4:
                month.setMonthNumber(4);
                month.setEnglishName("April");
                month.setItalianName("Aprile");
                month.setGermanName("April");
                break;
            case 5:
                month.setMonthNumber(5);
                month.setEnglishName("May");
                month.setItalianName("Maggio");
                month.setGermanName("Mai");
                break;
            case 6:
                month.setMonthNumber(6);
                month.setEnglishName("June");
                month.setItalianName("Giugno");
                month.setGermanName("Juni");
                break;
            case 7:
                month.setMonthNumber(7);
                month.setEnglishName("July");
                month.setItalianName("Luglio");
                month.setGermanName("Juli");
                break;
            case 8:
                month.setMonthNumber(8);
                month.setEnglishName("August");
                month.setItalianName("Agosto");
                month.setGermanName("August");
                break;
            case 9:
                month.setMonthNumber(9);
                month.setEnglishName("September");
                month.setItalianName("Settembre");
                month.setGermanName("September");
                break;
            case 10:
                month.setMonthNumber(10);
                month.setEnglishName("October");
                month.setItalianName("Ottobre");
                month.setGermanName("Oktober");
                break;
            case 11:
                month.setMonthNumber(11);
                month.setEnglishName("November");
                month.setItalianName("Novembre");
                month.setGermanName("November");
                break;
            case 12:
                month.setMonthNumber(12);
                month.setEnglishName("December");
                month.setItalianName("Dicembre");
                month.setGermanName("Dezember");
                break;
            default:
                return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().body(month);
    }
}
