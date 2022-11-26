package com.example.HauvatarStore.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.HauvatarStore.domain.Garmet;
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
        model.addAttribute("chartData", getChartData());
        
        
        return "mobile/manufacturerList";
    }

    private List<List<Object>> getChartData() {
    	List<String> countbyManufacturer = garmetRepository.getCountByManufacturer();
    	List parsedList = new ArrayList<List<String>>();
    	
    	for (String manufacturer : countbyManufacturer) {
    		String[] variables = manufacturer.split(",");
    		parsedList.add(List.of(variables[0], Integer.parseInt(variables[1])));
    	}

    	
		return parsedList;
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
    
    @RequestMapping(value = "/editManufacturermobile/{manufacturerId}", method = RequestMethod.GET)
    public String editManufacturer(@PathVariable("manufacturerId") Long manufacturerId, Model model) {
        model.addAttribute("manufacturer", mrepository.findById(manufacturerId));
        return "mobile/editManufacturer";
    }
	
    @RequestMapping(value = "/deleteManufacturermobile/{manufacturerId}", method = RequestMethod.GET)
    public String deleteManufacturer(@PathVariable("manufacturerId") Long manufacturerId, Model model) {
        mrepository.deleteById(manufacturerId);
        return "redirect:/manufacturerListmobile";
    }
    
    @RequestMapping(value = "/clothelistmobile" )
    public String garmetList(Model model) {
        model.addAttribute("clothes", garmetRepository.findAll());
        return "mobile/clothelist";
    }

    @RequestMapping(value = "/addmobile")
    public String addGarmet(Model model) {
        model.addAttribute("garmet", new Garmet());
        model.addAttribute("manufacturers", mrepository.findAll());
        return "mobile/addClothe";
    }

    @RequestMapping(value = "/savemobile", method = RequestMethod.POST)
    public String save(Model model, @ModelAttribute("garmet") @Valid Garmet garmet, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("manufacturers", mrepository.findAll());
            return "mobile/addClothe";
        }
        garmetRepository.save(garmet);
        return "redirect:/clothelistmobile";
    }

    @RequestMapping(value = "/deletemobile/{id}", method = RequestMethod.GET)
    public String deleteGarmet(@PathVariable("id") Long garmetId, Model model) {
        garmetRepository.deleteById(garmetId);
        return "redirect:/clothelistmobile";
    }

    @RequestMapping(value = "/editmobile/{id}", method = RequestMethod.GET)
    public String editGarmet(@PathVariable("id") Long garmetId, Model model) {
        model.addAttribute("garmet", garmetRepository.findById(garmetId));
        model.addAttribute("manufacturers", mrepository.findAll());
        return "mobile/editClothe";
    }
	
}