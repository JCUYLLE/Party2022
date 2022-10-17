package be.buschop.ap2022b.party.repositories;

import be.buschop.ap2022b.party.model.Artist;
import be.buschop.ap2022b.party.model.Venue;
import org.springframework.data.repository.CrudRepository;

public abstract class ArtistRepository implements CrudRepository<Artist, Integer> {
}
