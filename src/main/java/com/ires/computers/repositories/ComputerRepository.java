package com.ires.computers.repositories;

import com.ires.computers.models.Computer;
import com.ires.computers.viewmodels.ComputerNew;
import com.ires.computers.viewmodels.ComputerRow;
import java.util.List;
import org.springframework.stereotype.Component;

@Component(value="in-memory-repo")
public interface ComputerRepository
{
    List<ComputerRow> getAll(String namePart);
    Computer get(int id) throws NotFoundException ;
    void post(ComputerNew viewModel);
    void put(Computer viewModel) throws NotFoundException ;
    void delete(int id) throws NotFoundException ;
}
