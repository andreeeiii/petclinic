package pet.clinic.view.consult;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import pet.clinic.repository.ConsultRepository;

public class ConsultHBoxBuilder {

    public static HBox build() {

        ConsultRepository consultRepository = new ConsultRepository();
        ConsultButtonsBuilder buttonsBuilder = new ConsultButtonsBuilder(consultRepository);

        HBox hbox = new HBox();
        hbox.setPadding(new Insets(15, 12, 15, 12));
        hbox.setSpacing(10);
        hbox.setStyle("-fx-background-color: #336699;");

        Button buttonAddConsult = buttonsBuilder.buildAdd();
        Button buttonGetAllConsults = buttonsBuilder.buildGetAll();
        Button buttonDeleteConsults = buttonsBuilder.buildDelete();
        Button updateConsult = buttonsBuilder.buildUpdate();

        hbox.getChildren().addAll(buttonAddConsult, buttonGetAllConsults,
                buttonDeleteConsults, updateConsult);

        return hbox;
    }
}
