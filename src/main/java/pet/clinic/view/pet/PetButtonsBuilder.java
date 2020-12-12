package pet.clinic.view.pet;

import javafx.scene.control.Button;
import pet.clinic.model.Pet;
import pet.clinic.model.Race;
import pet.clinic.repository.PetRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public class PetButtonsBuilder {

    private final PetRepository petRepository;

    public PetButtonsBuilder(PetRepository petRepository) {

        this.petRepository = petRepository;
    }

    public Button buildDelete() {

        Button btn = new Button();
        btn.setText("Delete Pet");
        btn.setOnAction(event -> {
            Optional<Pet> optionalPet = petRepository.getAll().stream().findAny();
            optionalPet.ifPresent(petRepository::delete);
        });
        btn.setPrefSize(250, 20);
        return btn;
    }

    public Button buildAdd() {

        Button btn = new Button();
        btn.setText("Add Pet");
        btn.setOnAction(event -> {
            Pet pet = buildPet();
            petRepository.save(pet);
        });
        btn.setPrefSize(250, 20);
        return btn;
    }

    public Button buildGetAll() {

        Button btn = new Button();
        btn.setText("Get All Pets");
        btn.setOnAction(event -> {
            List<Pet> allPets = petRepository.getAll();
            for (Pet petRetrieved : allPets) {
                System.out.println(petRetrieved);
            }
        });
        btn.setPrefSize(250, 20);
        return btn;
    }

    public Button buildUpdate() {

        Button btn = new Button();
        btn.setText("Update Latest Pet");
        btn.setOnAction(event -> {
            Optional<Pet> optionalPet = petRepository.getAll().stream().findAny();
            if (optionalPet.isPresent()) {
                optionalPet.get().setOwnerName("Updated Owner Name");
                petRepository.update(optionalPet.get());
            }
        });
        btn.setPrefSize(250, 20);
        return btn;
    }

    private Pet buildPet() {

        Pet pet = new Pet();
        pet.setOwnerName("Andrei");
        pet.setVaccinated(true);
        pet.setRace(Race.BEAGLE);
        pet.setBirthdate(new Date());

        return pet;
    }
}
