package servises;

import models.Subj;

import java.util.List;

public interface SubjService {
    List<Subj> findAllByTitle(String name);
}
