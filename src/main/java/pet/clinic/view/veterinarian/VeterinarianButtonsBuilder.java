package pet.clinic.view.veterinarian;

import javafx.scene.control.Button;
import pet.clinic.model.Speciality;
import pet.clinic.model.Veterinarian;
import pet.clinic.repository.VeterinarianRepository;

import java.util.List;
import java.util.Optional;

public class VeterinarianButtonsBuilder {

    private final VeterinarianRepository veterinarianRepository;

    public VeterinarianButtonsBuilder(VeterinarianRepository veterinarianRepository) {
        this.veterinarianRepository = veterinarianRepository;
    }

    public Button buildDelete() {

        Button btn = new Button();
        btn.setText("Delete Veterinarian");
        btn.setOnAction(event -> {
            Optional<Veterinarian> optionalVet = veterinarianRepository.getAll().stream().findAny();
            optionalVet.ifPresent(veterinarianRepository::delete);
        });
        btn.setPrefSize(250, 20);
        return btn;
    }

    public Button buildAdd() {

        Button btn = new Button();
        btn.setText("Add Veterinarian");
        btn.setOnAction(event -> {
            Veterinarian vet = buildVeterinarian();
            veterinarianRepository.save(vet);
        });
        btn.setPrefSize(250, 20);
        return btn;
    }

    public Button buildGetAll() {

        Button btn = new Button();
        btn.setText("Get All Veterinarians");
        btn.setOnAction(event -> {
            List<Veterinarian> allVets = veterinarianRepository.getAll();
            for (Veterinarian vetRetrieved : allVets) {
                System.out.println(vetRetrieved);
            }
        });
        btn.setPrefSize(250, 20);
        return btn;
    }

    public Button buildUpdate() {

        Button btn = new Button();
        btn.setText("Update Latest Veterinarian");
        btn.setOnAction(event -> {
            Optional<Veterinarian> optionalVet = veterinarianRepository.getAll().stream().findAny();
            if (optionalVet.isPresent()) {
                optionalVet.get().setFirstName("Updated First Name");
                veterinarianRepository.update(optionalVet.get());
            }
        });
        btn.setPrefSize(250, 20);
        return btn;
    }


    private Veterinarian buildVeterinarian() {

        Veterinarian vet = new Veterinarian();
        vet.setAddress("test address");
        vet.setFirstName("test first name");
        vet.setLastName("test last name");
        vet.setSpeciality(Speciality.ANIMAL_WELFARE);

        return vet;
    }
}
