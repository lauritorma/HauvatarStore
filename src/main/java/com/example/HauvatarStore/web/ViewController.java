package com.example.HauvatarStore.web;

import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping( { "/", "/main", "/home"} )
    public String greeting(Device device) {
		
        String deviceType = "browser";
        String platform = "browser";
        String viewName = "homepage";
		
        if (device.isNormal()) {
            deviceType = "browser";
        } else if (device.isMobile()) {
            deviceType = "mobile";
            viewName = "mobile/homepage";
        } 
        platform = device.getDevicePlatform().name();
        
        if (platform.equalsIgnoreCase("UNKNOWN")) {
            platform = "browser";
        }
     	
        return viewName;
    }
}