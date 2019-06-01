package guru.springframework.springpetclinic.bootstrap;

import guru.springframework.springpetclinic.model.*;
import guru.springframework.springpetclinic.services.OwnerService;
import guru.springframework.springpetclinic.services.PetTypeService;
import guru.springframework.springpetclinic.services.SpecialityService;
import guru.springframework.springpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) throws Exception {

        if (petTypeService.findAll().size() == 0) {
            loadData();
        }
    }

    private void loadData() {
        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatType = petTypeService.save(cat);

        PetType bird = new PetType();
        bird.setName("Bird");
        PetType savedBirdType = petTypeService.save(bird);

        Owner michaelWeston = new Owner();
        michaelWeston.setFirstName("Michael");
        michaelWeston.setLastName("Weston");
        michaelWeston.setAddress("15th Cross, 9th Main");
        michaelWeston.setCity("Bangalore");
        michaelWeston.setTelephone("8899556622");

        Pet jimy = new Pet();
        jimy.setName("Jimy");
        ;
        jimy.setOwner(michaelWeston);
        jimy.setPetType(savedDogType);
        jimy.setBirthDate(LocalDate.now());

        michaelWeston.getPets().add(jimy);
        ownerService.save(michaelWeston);

        Owner fionaGlenanne = new Owner();
        fionaGlenanne.setFirstName("Fiona");
        fionaGlenanne.setLastName("Glenanne");
        fionaGlenanne.setAddress("21st Cross, 4th Main");
        fionaGlenanne.setCity("Mysore");
        fionaGlenanne.setTelephone("2233556688");

        Pet micky = new Pet();
        micky.setName("Micky");
        ;
        micky.setOwner(fionaGlenanne);
        micky.setPetType(savedCatType);
        micky.setBirthDate(LocalDate.now());

        fionaGlenanne.getPets().add(micky);
        ownerService.save(fionaGlenanne);

        Vet samAxe = new Vet();
        samAxe.setFirstName("Sam");
        samAxe.setLastName("Axe");
        samAxe.getSpecialities().add(savedRadiology);
        vetService.save(samAxe);

        Vet jessiePorter = new Vet();
        jessiePorter.setFirstName("Jessie");
        jessiePorter.setLastName("Porter");
        jessiePorter.getSpecialities().add(savedSurgery);
        vetService.save(jessiePorter);

        System.out.println("XXX---> Local Data loaded successfully");
    }
}
