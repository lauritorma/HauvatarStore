package com.example.HauvatarStore.web;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.HauvatarStore.domain.Garmet;
import com.example.HauvatarStore.domain.GarmetRepository;
import com.example.HauvatarStore.domain.Manufacturer;
import com.example.HauvatarStore.domain.ManufacturerRepository;


@Controller
public class ManufacturerController {

    @Autowired
    private ManufacturerRepository mrepository;
    @Autowired
    private GarmetRepository garmetRepository;

    // View all manufacturers in list

    @RequestMapping(value = { "/manufacturers", "/manufacturerList" })
    public String manufacturerList(Model model) {
        model.addAttribute("manufacturers", mrepository.findAll());
        return "/manufacturerList";
    }

    // Add new manufacturer

    @RequestMapping(value = "/addManufacturer")
    public String addManufacturer(Model model) {
        model.addAttribute("manufacturer", new Manufacturer());
        return "/addManufacturer";
    }

    // Save new manufacturer

    @RequestMapping(value = "/saveManufacturer", method = RequestMethod.POST)
    public String save(@ModelAttribute("manufacturer") @Valid Manufacturer manufacturer, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/addManufacturer";
        }
        mrepository.save(manufacturer);
        return "redirect:/manufacturerList";
    }

    // Edit manufacturer

    @RequestMapping(value = "/editManufacturer/{manufacturerId}", method = RequestMethod.GET)
    public String editManufacturer(@PathVariable("manufacturerId") Long manufacturerId, Model model) {
        model.addAttribute("manufacturer", mrepository.findById(manufacturerId));
        return "/editManufacturer";
    }

    // Delete manufacturer

    @RequestMapping(value = "/deleteManufacturer/{manufacturerId}/{manufacturerName}", method = RequestMethod.GET)
    public String deleteManufacturer(@PathVariable("manufacturerId") Long manufacturerId ,@PathVariable("manufacturerName") String manufacturerName, Model model, RedirectAttributes redirAttrs) {
    	//ILMOITUS
    	Iterable<Garmet> originalListiterable = garmetRepository.findAll();
    	
    	//Iterable to List
    	List<Garmet> originalList = new ArrayList<>();
    	originalListiterable.forEach(originalList::add);
    	System.out.println(originalList);
    	List<String> nameFilter = Arrays.asList(manufacturerName);
    	boolean contains = false;
    	
    	//Check if any garmets have the deleted manufacturer
    	for (Garmet garmet : originalList) {
    		if (garmet.getManufacturer().equals(manufacturerName)) {
    			contains = true;
    		}
    	}
    	
    	if (contains) {
    		redirAttrs.addFlashAttribute("error", "Valmistajalla "+manufacturerName+" on vielä vaatetietoja järjestelmässä");
    	} else {
    		redirAttrs.addFlashAttribute("success", "Valmistaja "+manufacturerName+"on poistettu järjestelmästä");
    	}
        mrepository.deleteById(manufacturerId);
        return "redirect:/manufacturerList";
    }

}
