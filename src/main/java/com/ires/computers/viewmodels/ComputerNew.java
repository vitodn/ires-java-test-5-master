package com.ires.computers.viewmodels;

import com.ires.computers.models.Computer;
import java.time.LocalDate;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class ComputerNew
{
    public static Computer map(ComputerNew viewModel)
    {
        if (viewModel == null) {
            return null;
        }
        
        var model = new Computer();
        model.setName(viewModel.getName());
        model.setPrice(viewModel.getPrice());
        model.setIsInStock(viewModel.isIsInStock());
        model.setReleaseDate(viewModel.getReleaseDate());
        return model;
    }
    
    @NotBlank(message="The Computer's Name is required!")
    private String name;
    
    @Min(value=0, message="The Computer's Price cannot be less than 0!")
    private double price;
    
    private boolean isInStock;
    
    private LocalDate releaseDate;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isIsInStock() {
        return isInStock;
    }
    public void setIsInStock(boolean isInStock) {
        this.isInStock = isInStock;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }
    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }
}
