/**
 * (C) Artur Boronat, 2015
 */
package eMarket.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import eMarket.EMarketApp;
import eMarket.domain.Product;

@Controller
@RequestMapping("/product")
public class ProductController {
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
    		binder.addValidators(new ProductValidator());
    }
    
    @RequestMapping("/")
    public String index(Model model) {
    	model.addAttribute("productList", EMarketApp.getStore().getProductList());
        return "form/productMaster";
    }
    
    @RequestMapping(value = "/productDetail", method = RequestMethod.GET)
    public String productDetail(@ModelAttribute("product") Product product, @RequestParam(value="productId", required=false, defaultValue="-1") int productId) {
    		if (productId >= 0) {
	    		// modify
    			// try to find a product in the product list of the store of the EMarketApp object 
    			// an optional object is an object that contains a value (in which case it is said to be present) or not 
	    		Optional<Product> productOpt = EMarketApp.getStore().getProductList().stream().filter(p -> (((Product) p).getId() == productId)).findAny();
	    		// unfortunately: jacoco does not provide full support for optional expressions (https://github.com/jacoco/jacoco/issues/345)
	    		// the line below will be partially covered (yellow)
	    		if (productOpt.isPresent()) { 
	    			// the product was found
		    		product.setId(productOpt.get().getId());
		    		product.setName(productOpt.get().getName());
		    		product.setDescription(productOpt.get().getDescription());
		    		product.setPrice(productOpt.get().getPrice());
	    		}
	    	} else {
	    		// add
	    		product.setId();
	    	}
	    	return "form/productDetail";
    }   
    
    @RequestMapping(value = "/add", params = "submit", method = RequestMethod.POST)
    public String productMaster(@Valid @ModelAttribute("product") Product product, BindingResult validationResult, Model model) {
    		if (validationResult.hasErrors()) {
    			return "form/productDetail";
    		} else {

		    	EMarketApp.getStore().getProductList().removeIf(p -> (p.getId() == product.getId()));
		    	EMarketApp.getStore().getProductList().add(product);
		   		
		    	model.addAttribute("productList", EMarketApp.getStore().getProductList());
		    return "form/productMaster";
    		}
    }   

    @RequestMapping(value = "/add", params = "cancel", method = RequestMethod.POST)
    public String productMaster(@ModelAttribute("product") Product product, Model model) {
    		model.addAttribute("productList", EMarketApp.getStore().getProductList());
    		return "form/productMaster";
    }   

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String productMaster(@RequestParam(value="productId", required=false, defaultValue="-1") int productId, Model model) {
	    	EMarketApp.getStore().getProductList().removeIf(p -> (p.getId() == productId));
	    	model.addAttribute("productList", EMarketApp.getStore().getProductList());
	    	return "form/productMaster";
    }   
    
    
    
}
