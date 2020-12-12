package pet.clinic.repository;

import pet.clinic.model.Veterinarian;

/**
 * Service in charge of doing CRUD operations on {@link Veterinarian} entity
 */
public class VeterinarianRepository extends CRUDRepository<Veterinarian> {

    public VeterinarianRepository() {

        super(Veterinarian.class);
    }
}
