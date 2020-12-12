import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import pet.clinic.view.consult.ConsultHBoxBuilder;
import pet.clinic.view.pet.PetHboxBuilder;
import pet.clinic.view.veterinarian.VeterinarianHBoxBuilder;


public class PetClinicApp extends Application {

    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("Pet Clinic Application");

        BorderPane root = new BorderPane();

        root.setTop(VeterinarianHBoxBuilder.build());
        root.setBottom(PetHboxBuilder.build());
        root.setCenter(ConsultHBoxBuilder.build());

        primaryStage.setScene(new Scene(root, 1000, 250));

        primaryStage.show();
    }
}


