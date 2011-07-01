package com.sitronics.filenet.core.storage.impl;

import javax.security.auth.Subject;

import com.filenet.api.core.Connection;
import com.filenet.api.core.Factory;
import com.filenet.api.core.ObjectStore;
import com.filenet.api.util.UserContext;
import com.sitronics.filenet.core.storage.FileNetStorage;

/**
 * @author Andrey Popov creates on 30.06.11 (17:21)
 */
public class FileNetStorageImpl implements FileNetStorage {

    private String username;
    private String password;
    private String jaasName;
    private String uri;
    private String objectStoreName;

    public FileNetStorageImpl() {
    }

    public FileNetStorageImpl(String username, String password, String jaasName, String uri, String objectStoreName) {
        this.username = username;
        this.password = password;
        this.jaasName = jaasName;
        this.uri = uri;
        this.objectStoreName = objectStoreName;
    }

    @Override
    public ObjectStore getObjectStore() {
        Connection connection = Factory.Connection.getConnection(uri);
        Subject subject = UserContext.createSubject(connection, username, password, jaasName);
        UserContext.get().pushSubject(subject);
        ObjectStore store = Factory.ObjectStore.getInstance(Factory.Domain.getInstance(connection, null), objectStoreName);
        return store;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getObjectStoreName() {
        return objectStoreName;
    }

    public void setObjectStoreName(String objectStoreName) {
        this.objectStoreName = objectStoreName;
    }

    public String getJaasName() {
        return jaasName;
    }

    public void setJaasName(String jaasName) {
        this.jaasName = jaasName;
    }
}
