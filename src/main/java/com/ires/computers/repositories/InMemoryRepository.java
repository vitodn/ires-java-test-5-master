package com.ires.computers.repositories;

import com.ires.computers.models.Computer;
import com.ires.computers.viewmodels.ComputerNew;
import com.ires.computers.viewmodels.ComputerRow;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import static java.util.stream.Collectors.toList;
import java.util.stream.IntStream;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component(value="in-memory-repo")
@Scope("prototype")
public class InMemoryRepository implements ComputerRepository
{
    private List<Computer> _models;
    private int _idCounter;
    
    public InMemoryRepository() {
        _models = new ArrayList<>();
        
        var c1 = new Computer();
        c1.setId(1);
        c1.setName("MacBook Pro Retina");
        c1.setPrice(3000.00);
        c1.setIsInStock(true);
        c1.setReleaseDate(LocalDate.of(2012, Month.MARCH, 1));
        _models.add(c1);
        
        var c2 = new Computer();
        c2.setId(2);
        c2.setName("Acer Nitro 5");
        c2.setPrice(1199.99);
        c2.setIsInStock(false);
        c2.setReleaseDate(LocalDate.of(2018, Month.SEPTEMBER, 10));
        _models.add(c2);
        
        _idCounter = 2;
    }
    
    @Override
    public List<ComputerRow> getAll(String namePart) {
        return _models.stream()
                .filter(c -> c.getName().toLowerCase().contains(namePart))
                .map(ComputerRow::map)
                .collect(toList());
    }

    @Override
    public Computer get(int id) throws NotFoundException {
        var found = _models.stream()
                .filter(c -> c.getId() == id)
                .findFirst();
        if (found.isPresent()) {
            return found.get();
        } else {
            throw new NotFoundException("computer not found!");
        }
    }

    @Override
    public void post(ComputerNew viewModel) {
        var model = ComputerNew.map(viewModel);
        model.setId(++_idCounter);
        _models.add(model);
    }

    @Override
    public void put(Computer viewModel) throws NotFoundException {
        var indexOpt = IntStream.range(0, _models.size())
                .filter(i -> viewModel.getId() == _models.get(i).getId())
                .findFirst();
            
        if (indexOpt.isPresent()) {
            _models.set(indexOpt.getAsInt(), viewModel);
        } else {
            throw new NotFoundException("Computer not found!");
        }
    }

    @Override
    public void delete(int id) throws NotFoundException {
        var computerOpt = _models.stream()
            .filter(c -> c.getId() == id)
            .findFirst();
        if (computerOpt.isPresent()) {
            _models.remove(computerOpt.get());
        } else {
            throw new NotFoundException("Computer not found!");
        }
    }
    
}
