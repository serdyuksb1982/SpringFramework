package com.serdyuk.spring.mvc_hibernate_aop.controller;

import com.serdyuk.spring.mvc_hibernate_aop.entity.Employee;
import com.serdyuk.spring.mvc_hibernate_aop.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
public class MyController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/")
    public String showAllEmployees(Model model) {

        List<Employee> allEmployees = employeeService.getAllEmployees();
        model.addAttribute("allEmployees", allEmployees);

        return "all-employees";
    }
    @RequestMapping("/addNewEmployee")
    public String addNewEmployee( Model model) {

        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "employee-info";

    }

    /**+
     * Атрибут @ModelAttribute 'employee' в методе adNewEmployee
     * метод saveEmployee вызывается как при создании нового работника (конструктор по умолчанию),
     * так и при изменении данных существующего работкника (конструктор с параметрами)
     */
    @RequestMapping("/saveEmployee")
    public String saveEmployee(@Valid @ModelAttribute("employee") Employee employee, BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            return "employee-info";
        } else {
            employeeService.saveEmployee(employee);

            return "redirect:/";
        }

    }
    @RequestMapping("/updateInfo")
    public String updateEmployee(@RequestParam("empId") int id, Model model) {
        Employee employee = employeeService.getEmployee(id);
        model.addAttribute("employee", employee);
        return "employee-info";
    }
    @RequestMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam("empId") int id, Model model) {

        employeeService.deleteEmployee(id);

        return "redirect:/";
    }
}
