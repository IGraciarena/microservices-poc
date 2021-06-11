package igraciarena.poc.msproducts.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@ConfigurationProperties(prefix = "couchbase")
@Slf4j
public class CouchbaseSetting {

    @Value("${app.couchbase.host-name}")
    private String hostName;

    @Value("${app.couchbase.user-name}")
    private String userName;

    @Value("${app.couchbase.password}")
    private String password;

    @Value("${app.couchbase.bucket-name}")
    private String bucketName;

    public CouchbaseSetting() {
        log.info("Loading Couchbase properties");
    }

    @PostConstruct
    public void postConstruct() {
        log.info("Couchbase properties -> hostName: '{}', bucketName: '{}', password: '{}'", hostName, bucketName, password);
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getBucketName() {
        return bucketName;
    }

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}