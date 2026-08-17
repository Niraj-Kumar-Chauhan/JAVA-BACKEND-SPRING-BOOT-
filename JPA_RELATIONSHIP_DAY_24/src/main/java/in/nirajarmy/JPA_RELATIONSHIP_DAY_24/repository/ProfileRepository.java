package in.nirajarmy.JPA_RELATIONSHIP_DAY_24.repository;


import in.nirajarmy.JPA_RELATIONSHIP_DAY_24.model.Profile;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class ProfileRepository {

    @PersistenceContext
    EntityManager entityManager;

    public void save (Profile profile) {
        entityManager.persist(profile);
    }
}
