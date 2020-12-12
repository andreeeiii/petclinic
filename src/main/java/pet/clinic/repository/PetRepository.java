package pet.clinic.repository;

import pet.clinic.model.Pet;

/**
 * Service in charge of doing CRUD operations on {@link Pet} entity
 */
public class PetRepository extends CRUDRepository<Pet> {

    public PetRepository() {

        super(Pet.class);
    }
}
