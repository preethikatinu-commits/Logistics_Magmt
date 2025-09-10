package com.example.demo.product_controll;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;   // ✅ Correct import
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.product_Dto.ProductDto;
import com.example.demo.product_service.ProductService;

@Controller
@RequestMapping("/products")
public class ProductWebController {

    @Autowired
    private ProductService service;

    @GetMapping("/listProducts")
    public String listProducts(Model model) {
        model.addAttribute("products", service.getAllProducts());
        return "list-products"; // loads list-products.jsp
    }

    @GetMapping("/newProduct")
    public String newProduct() {
        return "newProduct";
    }

    @PostMapping("/createProduct")
    public String createProduct(@ModelAttribute ProductDto dto) {
        service.createProduct(dto);
        return "redirect:/products/listProducts";
    }

    @GetMapping("/editProduct")
    public String editProduct(@RequestParam Long id, Model model) {
        model.addAttribute("product", service.getProductById(id));
        return "edit-product";
    }

    @PostMapping("/updateProduct")
    public String updateProduct(@ModelAttribute ProductDto dto) {
        service.updateProduct(dto.getId(), dto);
        return "redirect:/products/listProducts";
    }

    @GetMapping("/deleteProduct")
    public String deleteProduct(@RequestParam Long id) {
        service.deleteProduct(id);
        return "redirect:/products/listProducts";
    }
}
