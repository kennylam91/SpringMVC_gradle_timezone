package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.TimeZone;

@Controller
public class TimeController {

    @GetMapping("worldclock")
    public ModelAndView getTimeByTimeZone(@RequestParam(name="city",defaultValue = "Asia/Ho_Chi_Minh") String city){
        ModelAndView modelAndView = new ModelAndView("index");
        Date date = new Date();
        TimeZone local = TimeZone.getDefault();
        TimeZone locale = TimeZone.getTimeZone(city);
        long locale_time = date.getTime() +
                (locale.getRawOffset() - local.getRawOffset());
        date.setTime(locale_time);

        modelAndView.addObject("date",date);
        modelAndView.addObject("city",city);
        return modelAndView;
    }
}
