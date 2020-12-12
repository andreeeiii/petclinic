package pet.clinic.repository;

import pet.clinic.model.Consult;

/**
 * Service in charge of doing CRUD operations on {@link Consult} entity
 */
public class ConsultRepository extends CRUDRepository<Consult> {

    public ConsultRepository() {

        super(Consult.class);
    }
}
