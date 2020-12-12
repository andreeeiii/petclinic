package pet.clinic.view.consult;

import javafx.scene.control.Button;
import pet.clinic.model.Consult;
import pet.clinic.repository.ConsultRepository;

import java.util.List;
import java.util.Optional;

public class ConsultButtonsBuilder {

    private final ConsultRepository consultRepository;

    public ConsultButtonsBuilder(ConsultRepository consultRepository) {

        this.consultRepository = consultRepository;
    }

    public Button buildDelete() {

        Button btn = new Button();
        btn.setText("Delete Consultation");
        btn.setOnAction(event -> {
            Optional<Consult> optionalConsult = consultRepository.getAll().stream().findAny();
            optionalConsult.ifPresent(consultRepository::delete);
        });
        btn.setPrefSize(250, 20);
        return btn;
    }

    public Button buildAdd() {

        Button btn = new Button();
        btn.setText("Add Consultation");
        btn.setOnAction(event -> {
            Consult consult = buildConsult();
            consultRepository.save(consult);
        });
        btn.setPrefSize(250, 20);
        return btn;
    }

    public Button buildGetAll() {

        Button btn = new Button();
        btn.setText("Get All Consultations");
        btn.setOnAction(event -> {
            List<Consult> allConsults = consultRepository.getAll();
            for (Consult consultRetrieved : allConsults) {
                System.out.println(consultRetrieved);
            }
        });
        btn.setPrefSize(250, 20);
        return btn;
    }

    public Button buildUpdate() {

        Button btn = new Button();
        btn.setText("Update Latest Consultation");
        btn.setOnAction(event -> {
            Optional<Consult> optionalConsult = consultRepository.getAll().stream().findAny();
            optionalConsult.ifPresent(consult -> consult.setDescription("New Description"));
            optionalConsult.ifPresent(consultRepository::update);
        });
        btn.setPrefSize(250, 20);
        return btn;
    }

    private Consult buildConsult() {

        Consult consult = new Consult();
        consult.setDescription("description");

        return consult;
    }
}
