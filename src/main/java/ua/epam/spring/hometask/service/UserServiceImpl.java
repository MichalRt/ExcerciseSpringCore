package ua.epam.spring.hometask.service;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import ua.epam.spring.hometask.domain.User;
import ua.epam.spring.hometask.repository.DataStorage;

public class UserServiceImpl implements UserService {

    @Nullable
    @Override
    public User getUserByEmail(@Nonnull String email) {
        return DataStorage.getUserDatabase().entrySet().stream().filter(o->o.getValue().getEmail().equals(email)).map(o->o.getValue()).findAny().orElse(new User());
    }

    @Override
    public User save(@Nonnull User object) {
        if (getAll().stream().filter(o -> o.equals(object)).findFirst().equals(Optional.empty())) {
            User user = DataStorage.getUserDatabase().put(DataStorage.getIdUserCounter(), object);
            DataStorage.idUserCounter++;
            return user;
        } else {
            return null;
        }
    }

    @Override
    public void remove(@Nonnull User object) {

        for(Iterator<Integer> it = DataStorage.getUserDatabase().keySet().iterator();
            it.hasNext(); ) {
            Integer entry = it.next();
            User value = DataStorage.getUserDatabase().get(entry);
            if (value.equals(object)) {
                it.remove();
            }
        }
    }

    @Override
    public User getById(@Nonnull Long id) {
        return DataStorage.getUserDatabase().entrySet().stream().filter(o->o.getValue().getId().equals(id)).map(o->o.getValue()).findAny().orElse(null);
    }

    @Nonnull
    @Override
    public Collection<User> getAll() {
        return DataStorage.getUserDatabase().entrySet().stream().map(o->o.getValue())
            .collect(Collectors.toList());
    }
}
