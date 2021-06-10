package igraciarena.poc.msproducts.adapters.output.persistance;


import igraciarena.poc.msproducts.adapters.output.Category;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CouchbaseRepository<Category, String> {

}
