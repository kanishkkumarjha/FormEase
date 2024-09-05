package com.formfiller.main.controllers;

import com.formfiller.main.model.Form;
import com.formfiller.main.repository.FormRepository;
import com.formfiller.main.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class FormController {

    @Autowired
    private FormRepository formRepository;

    @Autowired
    private EmailService emailService;

    @PostMapping("/submit-form")
    public ResponseEntity<String> submitForm(@RequestBody Form form) {
        // Validate phone number
        Pattern phoneRegex = Pattern.compile("^[0-9]{10}$");
        if (!phoneRegex.matcher(form.getPhoneNumber()).matches()) {
            return new ResponseEntity<>("Invalid phone number", HttpStatus.BAD_REQUEST);
        }

        // Save form to the database
        formRepository.save(form);

        // Send email
        emailService.sendEmail(form.getEmail(), "Form Submission Successful",
                "Thank you, " + form.getName() + ", for submitting the form!");

        return new ResponseEntity<>("Form submitted successfully!", HttpStatus.OK);
    }

    @GetMapping("/forms")
    public List<Form> getForms() {
        return formRepository.findAll();
    }
}