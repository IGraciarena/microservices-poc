package igraciarena.poc.mscustomers.adapters.output.persistance;

import igraciarena.poc.mscustomers.adapters.output.dbentities.Region;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegionRepository extends JpaRepository<Region, Long> {

    Optional<Region> findByName(String name);

    Page<Region> findAll(Pageable pageable);
}
