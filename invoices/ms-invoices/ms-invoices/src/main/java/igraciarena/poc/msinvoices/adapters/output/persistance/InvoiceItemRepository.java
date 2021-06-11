package igraciarena.poc.msinvoices.adapters.output.persistance;

import igraciarena.poc.msinvoices.adapters.output.dbentities.InvoiceItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceItemRepository extends JpaRepository<InvoiceItem, Long> {
}
