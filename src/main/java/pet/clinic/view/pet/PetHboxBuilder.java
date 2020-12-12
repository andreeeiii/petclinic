package pet.clinic.view.pet;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import pet.clinic.repository.PetRepository;

public class PetHboxBuilder {

    public static HBox build() {

        PetRepository petRepository = new PetRepository();
        PetButtonsBuilder buttonsBuilder = new PetButtonsBuilder(petRepository);

        HBox hbox = new HBox();
        hbox.setPadding(new Insets(15, 12, 15, 12));
        hbox.setSpacing(10);
        hbox.setStyle("-fx-background-color: #336699;");

        Button buttonAddPet = buttonsBuilder.buildAdd();
        Button buttonGetAllPets = buttonsBuilder.buildGetAll();
        Button buttonDeletePet = buttonsBuilder.buildDelete();
        Button updatePet = buttonsBuilder.buildUpdate();

        hbox.getChildren().addAll(buttonAddPet, buttonGetAllPets,
                buttonDeletePet, updatePet);

        return hbox;
    }
}
