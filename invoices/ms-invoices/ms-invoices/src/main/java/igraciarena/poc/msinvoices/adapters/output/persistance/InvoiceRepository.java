package igraciarena.poc.msinvoices.adapters.output.persistance;


import igraciarena.poc.msinvoices.adapters.output.dbentities.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

    List<Invoice> findAllByCustomerId(Long customerId);

}
