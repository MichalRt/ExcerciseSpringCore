package ua.epam.spring.hometask.service;

import java.util.Collection;
import java.util.Iterator;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import ua.epam.spring.hometask.domain.Event;
import ua.epam.spring.hometask.domain.User;
import ua.epam.spring.hometask.repository.DataStorage;

public class EventServiceImpl implements EventService {


    @Nullable
    @Override
    public Event getByName(@Nonnull String name) {
        return DataStorage.getEventDatabase().entrySet().stream().map(o->o.getValue()).filter(o->o.getName().equals(name)).findAny().orElse(null);
    }

    @Override
    public Event save(@Nonnull Event object) {
        if (getAll().stream().filter(o -> o.equals(object)).findFirst().equals(Optional.empty())) {
            Event event = DataStorage.getEventDatabase().put(DataStorage.getIdEventCounter(), object);
            DataStorage.idUserCounter++;
            return event;
        } else {
            return null;
        }
    }

    @Override
    public void remove(@Nonnull Event object) {


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
    public Event getById(@Nonnull Long id) {
        return DataStorage.getEventDatabase().entrySet().stream().filter(o->o.getValue().getId().equals(id)).map(o->o.getValue()).findAny().orElse(null);
    }

    @Nonnull
    @Override
    public Collection<Event> getAll() {
        return DataStorage.getEventDatabase().entrySet().stream().map(o->o.getValue())
            .collect(Collectors.toList());
    }
}
