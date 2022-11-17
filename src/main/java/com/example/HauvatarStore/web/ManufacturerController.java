package com.example.HauvatarStore.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.HauvatarStore.domain.Manufacturer;
import com.example.HauvatarStore.domain.ManufacturerRepository;

@Controller
public class ManufacturerController {

    @Autowired
    private ManufacturerRepository mrepository;

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

    @RequestMapping(value = "/deleteManufacturer/{manufacturerId}", method = RequestMethod.GET)
    public String deleteManufacturer(@PathVariable("manufacturerId") Long manufacturerId, Model model) {
        mrepository.deleteById(manufacturerId);
        return "redirect:/manufacturerList";
    }

}
