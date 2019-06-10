package guru.springframework.springpetclinic.services;

import guru.springframework.springpetclinic.model.Visit;
import org.springframework.stereotype.Service;

@Service
public interface VisitService extends CrudService<Visit, Long> {
}
