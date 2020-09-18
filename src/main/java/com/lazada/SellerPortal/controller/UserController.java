package com.lazada.SellerPortal.controller;

import com.lazada.SellerPortal.entity.AddressEntity;
import com.lazada.SellerPortal.entity.BankEntity;
import com.lazada.SellerPortal.entity.IdentityEntity;
import com.lazada.SellerPortal.entity.UserEntity;
import com.lazada.SellerPortal.service.AddressService;
import com.lazada.SellerPortal.service.BankService;
import com.lazada.SellerPortal.service.IdentityService;
import com.lazada.SellerPortal.service.UserService;
import com.lazada.SellerPortal.vo.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    public String userId;

    @Autowired
    AddressService addressService;

    @Autowired
    IdentityService identityService;

    @Autowired
    BankService bankService;

    @PostMapping("/save")
    public String registration(@Valid RegistrationVo vo, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            Map<String, String> errors = result.getFieldErrors().stream().collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
            redirectAttributes.addFlashAttribute("errors", errors);

            return "redirect:http://localhost:8080/registration.html";
        }

        UserEntity user = userService.createUser(vo);
        if (user == null) {
            Map<String, String> errors = new HashMap<>();
            errors.put("msg", "username or mobile has been registered");
            redirectAttributes.addFlashAttribute("errors", errors);
            return "redirect:http://localhost:8080/registration.html";
        } else {
            return "redirect:http://localhost:8080/login.html";
        }
    }

    @PostMapping("/authenticate")
    public String login(@Valid LoginVo longinVo, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            Map<String, String> errors = result.getFieldErrors().stream().collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
            redirectAttributes.addFlashAttribute("errors", errors);
            return "redirect:http://localhost:8080/login.html";
        }
        UserEntity userEntity = userService.authenticate(longinVo);
        if (userEntity == null) {
            Map<String, String> errors = new HashMap<>();
            errors.put("msg", "email or password may not valid, please try again");
            redirectAttributes.addFlashAttribute("errors", errors);
            return "redirect:http://localhost:8080/login.html";
        } else {
            userId = userEntity.getUserId();
            return "redirect:http://localhost:8080/dashboard.html";
        }
    }

    @PostMapping("/address")
    public String saveAddress(@Valid AddressVo vo, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            Map<String, String> errors = result.getFieldErrors().stream().collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
            redirectAttributes.addFlashAttribute("errors", errors);
            return "redirect:http://localhost:8080/address.html";
        }
        AddressEntity save = addressService.save(vo, userId);
        if (save == null) {
            Map<String, String> errors = new HashMap<>();
            errors.put("msg", "Save Address failed, please try again");
            redirectAttributes.addFlashAttribute("errors", errors);
            return "redirect:http://localhost:8080/address.html";
        }
        return "redirect:http://localhost:8080/dashboard.html";
    }

    @PostMapping("/identity")
    public String saveIdentity(@Valid IdentityVo vo, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            Map<String, String> errors = result.getFieldErrors().stream().collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
            redirectAttributes.addFlashAttribute("errors", errors);
            return "redirect:http://localhost:8080/identity.html";
        }
        IdentityEntity save = identityService.save(vo, userId);
        if (save == null) {
            Map<String, String> errors = new HashMap<>();
            errors.put("msg", "Save Identity failed, please try again");
            redirectAttributes.addFlashAttribute("errors", errors);
            return "redirect:http://localhost:8080/identity.html";
        }
        return "redirect:http://localhost:8080/dashboard.html";
    }

    @PostMapping("/bank")
    public String saveIdentity(@Valid BankVo vo, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            Map<String, String> errors = result.getFieldErrors().stream().collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
            redirectAttributes.addFlashAttribute("errors", errors);
            return "redirect:http://localhost:8080/bank.html";
        }
        BankEntity save = bankService.save(vo, userId);
        if (save == null) {
            Map<String, String> errors = new HashMap<>();
            errors.put("msg", "Save Identity failed, please try again");
            redirectAttributes.addFlashAttribute("errors", errors);
            return "redirect:http://localhost:8080/bank.html";
        }
        return "redirect:http://localhost:8080/dashboard.html";
    }
}
