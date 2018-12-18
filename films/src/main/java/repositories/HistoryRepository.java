package repositories;

import models.HistoryPart;
import models.Subj;

import java.util.List;
import java.util.Optional;

public interface HistoryRepository extends CrudRepository<HistoryPart> {
    Optional<Subj> findAllByUser(Long id);
    @Deprecated
    public List<HistoryPart> findAll(long limit, long offset);
}

