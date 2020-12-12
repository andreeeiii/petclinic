package pet.clinic.view.veterinarian;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import pet.clinic.repository.VeterinarianRepository;

public class VeterinarianHBoxBuilder {

    public static HBox build() {

        VeterinarianRepository veterinarianRepository = new VeterinarianRepository();
        VeterinarianButtonsBuilder buttonsBuilder = new VeterinarianButtonsBuilder(veterinarianRepository);

        HBox hbox = new HBox();
        hbox.setPadding(new Insets(15, 12, 15, 12));
        hbox.setSpacing(10);
        hbox.setStyle("-fx-background-color: #336699;");

        Button buttonAddVeterinarian = buttonsBuilder.buildAdd();
        Button buttonGetAllVeterinarians = buttonsBuilder.buildGetAll();
        Button buttonDeleteVeterinarian = buttonsBuilder.buildDelete();
        Button updateVeterinarian = buttonsBuilder.buildUpdate();

        hbox.getChildren().addAll(buttonAddVeterinarian, buttonGetAllVeterinarians,
                buttonDeleteVeterinarian, updateVeterinarian);

        return hbox;
    }
}
