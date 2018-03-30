package ua.epam.spring.hometask.service;

import java.util.Set;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import ua.epam.spring.hometask.domain.Auditorium;
import ua.epam.spring.hometask.domain.User;
import ua.epam.spring.hometask.repository.DataStorage;

public class AuditoriumImpl implements AuditoriumService {

    @Nonnull
    @Override
    public Set<Auditorium> getAll() {
        return DataStorage.getAuditoriumDatabase().entrySet().stream().map(o->o.getValue())
            .collect(Collectors.toSet());
    }

    @Nullable
    @Override
    public Auditorium getByName(@Nonnull String name) {
        return DataStorage.getAuditoriumDatabase().entrySet().stream().map(o->o.getValue()).filter(o->o.getName().equals(name)).findAny().orElse(null);
    }
}
