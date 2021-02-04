package org.acme.service;

import javax.enterprise.context.ApplicationScoped;

/**
 * @author Stan
 */
@ApplicationScoped
public class TestService {
    public String testMethod() {
        return "hello";
    }
}
