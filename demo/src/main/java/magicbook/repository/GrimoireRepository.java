package magicbook.repository;

import magicbook.model.Grimoire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrimoireRepository extends JpaRepository<Grimoire, Integer> {
}

