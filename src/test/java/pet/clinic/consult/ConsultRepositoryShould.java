package pet.clinic.consult;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import pet.clinic.model.Consult;
import pet.clinic.repository.ConsultRepository;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ConsultRepositoryShould {

    public static final String NEW_DESCRIPTION = "new description";
    private final ConsultRepository repository = new ConsultRepository();

    @AfterEach
    public void cleanUp() {

        repository.deleteAll();
    }

    @Test
    public void getById() {

        // setup
        Consult expected = buildConsult();
        Consult savedExpected = repository.save(expected);

        // execute
        Consult actual = repository.getById(savedExpected.getId());

        // verify
        assertConsult(expected, actual);
    }

    @Test
    public void getAll() {

        // setup
        Consult expected = buildConsult();
        repository.save(expected);

        // execute
        List<Consult> actual = repository.getAll();

        // verify
        assertEquals(1, actual.size());
        assertConsult(expected, actual.get(0));
    }

    @Test
    public void save() {

        // setup
        Consult expected = buildConsult();

        // execute
        Consult savedExpected = repository.save(expected);

        // verify
        Consult actual = repository.getById(savedExpected.getId());
        assertConsult(expected, actual);
    }

    @Test
    public void delete() {

        // setup
        Consult expected = buildConsult();
        Consult savedExpected = repository.save(expected);

        // execute
        repository.delete(expected);

        // verify
        assertNull(repository.getById(savedExpected.getId()));
    }

    @Test
    public void update() {

        // setup
        Consult expected = buildConsult();
        Consult savedExpected = repository.save(expected);
        savedExpected.setDescription(NEW_DESCRIPTION);

        // execute
        repository.update(savedExpected);

        // verify
        Consult updatedConsult = repository.getById(savedExpected.getId());
        assertEquals(NEW_DESCRIPTION, updatedConsult.getDescription());
    }

    private void assertConsult(Consult expected, Consult actual) {

        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        assertEquals(df.format(expected.getDate()), df.format(actual.getDate()));
        assertEquals(expected.getDescription(), actual.getDescription());
        assertEquals(expected.getId(), actual.getId());
    }

    private Consult buildConsult() {

        Consult consult = new Consult();
        consult.setDate(new Date());
        consult.setDescription("test description");

        return consult;
    }

}