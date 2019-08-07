package com.ires.computers.viewmodels;

import com.ires.computers.models.Computer;

public class ComputerRow
{
    public static ComputerRow map(Computer model)
    {
        var vm = new ComputerRow();
        vm.setId(model.getId());
        vm.setName(model.getName());
        vm.setPrice(model.getPrice());
        return vm;
    }
    
    private int id;
    private String name;
    private double price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
    
    
}
