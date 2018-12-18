package repositories;

import models.Subj;
import models.User;

import java.util.Optional;

public interface SubjRepository extends CrudRepository<Subj> {
    Optional<Subj>findOneByName(String name);
    Optional<Subj>findOneById(Long id);
}
