package com.example.HauvatarStore.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.HauvatarStore.domain.GarmetRepository;
import com.example.HauvatarStore.domain.Manufacturer;
import com.example.HauvatarStore.domain.ManufacturerRepository;

@Controller
public class MobileController {
	@Autowired
    private GarmetRepository garmetRepository;
    @Autowired
    private ManufacturerRepository mrepository;
	
    @RequestMapping(value =  "/manufacturerListmobile" )
    public String manufacturerList(Model model) {
        model.addAttribute("manufacturers", mrepository.findAll());
        return "mobile/manufacturerList";
    }
    
    @RequestMapping(value = "/addManufacturermobile")
    public String addManufacturer(Model model) {
        model.addAttribute("manufacturer", new Manufacturer());
        return "mobile/addManufacturer";
    }
    
    @RequestMapping(value = "/saveManufacturermobile", method = RequestMethod.POST)
    public String save(@ModelAttribute("manufacturer") @Valid Manufacturer manufacturer, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "mobile/addManufacturer";
        }
        mrepository.save(manufacturer);
        return "redirect:/manufacturerListmobile";
    }
	
	
	
	
	
	
	
	
	
	
	
}