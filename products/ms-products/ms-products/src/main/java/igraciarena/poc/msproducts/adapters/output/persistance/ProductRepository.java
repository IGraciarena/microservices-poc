package igraciarena.poc.msproducts.adapters.output.persistance;


import igraciarena.poc.msproducts.adapters.output.Product;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CouchbaseRepository<Product, String> {

}
