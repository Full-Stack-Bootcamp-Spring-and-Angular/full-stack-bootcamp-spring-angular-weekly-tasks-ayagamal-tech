package main.com.myApp.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;

@Controller
public class HomeController
{

    @RequestMapping("/")
    public String showHomePage()
    {
        return "formPage";
    }

    @RequestMapping("/processForm")
    public String processForm(@RequestParam("first_name") String FName , @RequestParam("last_name") String Lname, @RequestParam("email_address") String email, @RequestParam("data_of_birth") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date, @RequestParam("city") String city, Model model)
    {

        //step2: add name to model
        model.addAttribute("first_name" , FName);
        model.addAttribute("last_name" , Lname);
        model.addAttribute("email_address" , email);
        model.addAttribute("date_of_birth" , date);
        model.addAttribute("city" , city);


        //step3: return view page
        return "resultPage";
    }
}


