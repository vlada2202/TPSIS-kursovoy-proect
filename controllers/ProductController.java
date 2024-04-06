package com.example.proba.controllers;

import com.example.proba.models.Products;
import com.example.proba.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class ProductController {
 private final ProductService productService;

    @GetMapping("/")
    public String product(@RequestParam(name="title",required = false) String title, Principal principal,Model model) {
        model.addAttribute("products",productService.listProducts(title));
        model.addAttribute("user",productService.getUserByPrincipal(principal));
        return "products";
    }

    @GetMapping("/product/{id}")
    public String productInfo(@PathVariable Long id, Model model,Principal principal)
    {
        Products products=productService.getProductById(id);
        model.addAttribute("product",products);
        model.addAttribute("images",products.getImages());
        model.addAttribute("user",productService.getUserByPrincipal(principal));
        return "product-info";
    }

    @GetMapping("/product/create")
    public String productview() {
        return "addproduct";
    }

    @PostMapping("/product/create")
    public String createProduct(@RequestParam("file1") MultipartFile file1,
                                @RequestParam("file2") MultipartFile file2,
                                @RequestParam("file3") MultipartFile file3,
                                @RequestParam("price") int price,
                                Products product, Principal principal, Model model) throws IOException {
        if (price <= 0) {
            model.addAttribute("error", "Цена должна быть больше 0.");
            model.addAttribute("productService", product);
            return "addproduct";
        }
        else {
            productService.saveProduct(principal, product, file1, file2, file3);
            return "redirect:/";
        }
    }

    @PostMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable Long id, Principal principal) {
        productService.deleteProduct(id);
        return "redirect:/";
    }
}
