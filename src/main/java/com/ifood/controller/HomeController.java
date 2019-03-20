
package com.ifood.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Ishara Dikkumbura
 */

@Controller
public class HomeController {
    
   
  
   
    @RequestMapping(value="/")
    public String showIndex(){
        return "index";
    }
}