package guru.springframework.springpetclinic.bootstrap;

import guru.springframework.springpetclinic.model.Owner;
import guru.springframework.springpetclinic.model.Pet;
import guru.springframework.springpetclinic.model.PetType;
import guru.springframework.springpetclinic.model.Vet;
import guru.springframework.springpetclinic.services.OwnerService;
import guru.springframework.springpetclinic.services.PetTypeService;
import guru.springframework.springpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

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
        jimy.setName("Jimy");;
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
        micky.setName("Micky");;
        micky.setOwner(fionaGlenanne);
        micky.setPetType(savedCatType);
        micky.setBirthDate(LocalDate.now());

        fionaGlenanne.getPets().add(micky);
        ownerService.save(fionaGlenanne);

        System.out.println("Loaded Owners");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");
        vetService.save(vet2);

        System.out.println("Loaded Vets");
    }
}
