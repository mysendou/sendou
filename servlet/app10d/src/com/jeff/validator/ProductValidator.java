package com.jeff.validator;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.jeff.form.ProductionForm;

public class ProductValidator {
    public List<String> validator(ProductionForm productionForm) {
        List<String> errors = new ArrayList<String>();
        String name = productionForm.getName();
        if (StringUtils.isEmpty(name)) {
            errors.add("Production must have a name");
        }
        
        String price = productionForm.getPrice();
        if (StringUtils.isEmpty(price)) {
            errors.add("Production must have a price");
        } else {
            try {
                Float.parseFloat(price);
            } catch (Exception e) {
                errors.add("Invalid price value");
            }
        }
        return errors;
    }
}
