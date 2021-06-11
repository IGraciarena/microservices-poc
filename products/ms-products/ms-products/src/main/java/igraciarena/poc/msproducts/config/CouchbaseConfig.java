package igraciarena.poc.msproducts.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.core.query.Consistency;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;


@Configuration
@EnableCouchbaseRepositories(basePackages = {"com.busleiman.shppproducts.adapters.output"})
@Slf4j
public class CouchbaseConfig extends AbstractCouchbaseConfiguration {

    @Autowired
    private CouchbaseSetting couchbaseSetting;


    @Override
    public String getConnectionString() {
        log.info("Registering host '{}' for couchbase cluster", couchbaseSetting.getHostName());
        return couchbaseSetting.getHostName();
    }

    @Override
    public String getUserName() {
        log.info("Registering user name '{}' for couchbase cluster", couchbaseSetting.getUserName());
        return couchbaseSetting.getUserName();
    }

    @Override
    public String getPassword() {
        log.info("Get bucket password '{}'", couchbaseSetting.getPassword());
        return couchbaseSetting.getPassword();
    }

    @Override
    public String getBucketName() {
        log.info("Opening bucket '{}'", couchbaseSetting.getBucketName());
        return couchbaseSetting.getBucketName();
    }

    public Consistency getDefaultConsistency() {
        // By default, READ_YOUR_OWN_WRITES
        // Values: READ_YOUR_OWN_WRITES, STRONGLY_CONSISTENT, UPDATE_AFTER, EVENTUALLY_CONSISTENT
        return Consistency.READ_YOUR_OWN_WRITES;
    }

    @Override
    public String typeKey() {
        // By default, this attribute is named "_class".
        // Spring Data automatically adds to each document an attribute containing the full class name of the entity.
        // This field is the one used by N1QL queries to filter only documents corresponding to the repository’s entity.
        return "type";
    }


}
