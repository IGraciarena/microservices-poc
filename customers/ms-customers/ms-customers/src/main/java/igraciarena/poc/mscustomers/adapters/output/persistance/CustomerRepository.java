package igraciarena.poc.mscustomers.adapters.output.persistance;

import igraciarena.poc.mscustomers.adapters.output.dbentities.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Page<Customer> findAllByRegionId(Long regionId, Pageable pageable);

    Page<Customer> findAllByFirstNameAndLastName(String firstName, String lastName, Pageable pageable);

    Page<Customer> findAllByLastNameContaining(String LastName, Pageable pageable);

    Optional<Customer> findByEmail(String email);
}
