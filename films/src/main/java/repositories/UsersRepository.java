package repositories;

import models.User;

import java.util.Optional;

public interface UsersRepository extends CrudRepository<User> {
    Optional<User> findOneByName(String id);
    Optional<User> findOneBySession(String session);

    @Deprecated
    public void updateSession(String name, String session);
    @Deprecated
    public void updateAvatar(Long id, String avatar);
}
