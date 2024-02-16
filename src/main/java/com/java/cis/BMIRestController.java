
package com.java.cis;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bmirest")
public class BMIRestController {

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String calculateBMI(@RequestParam("height") double heightInches, @RequestParam("weight") double weightLbs) {
        return calculateBMIValue(heightInches, weightLbs);
    }

    private String calculateBMIValue(double heightInches, double weightLbs) {
        // Convert height from inches to meters
        double heightMeters = heightInches * 0.0254; // 1 inch = 0.0254 meters

        // Convert weight from pounds to kilograms
        double weightKg = weightLbs * 0.453592; // 1 pound = 0.453592 kilograms

        // Calculate BMI
        double bmi = weightKg / (heightMeters * heightMeters);

        // Round BMI to two decimal places
        bmi = Math.round(bmi * 100.0) / 100.0;

        return Double.toString(bmi);
    }
}