package com.ejwa.security;

import com.ejwa.orm.model.dao.CustomerDAO;
import javax.enterprise.context.ApplicationScoped;
import javax.security.enterprise.identitystore.CredentialValidationResult;
import javax.security.enterprise.identitystore.IdentityStore;
import java.util.*;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.security.enterprise.authentication.mechanism.http.BasicAuthenticationMechanismDefinition;
import javax.security.enterprise.authentication.mechanism.http.CustomFormAuthenticationMechanismDefinition;
import javax.security.enterprise.authentication.mechanism.http.LoginToContinue;
import javax.security.enterprise.credential.Credential;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import static javax.security.enterprise.identitystore.CredentialValidationResult.INVALID_RESULT;
import org.apache.commons.codec.digest.DigestUtils;

@RequestScoped
@CustomFormAuthenticationMechanismDefinition(loginToContinue = @LoginToContinue(useForwardToLogin = false))
class InMemoryIdentityStore4Authorization implements IdentityStore {

    @EJB
    private CustomerDAO customerDAO;
    
    @PostConstruct
    private void init() {
        customerDAO.register_customer_signup("yazan_ghafir@challando.com", DigestUtils.sha256Hex("Yazan123"));
        customerDAO.register_customer_signup("madeleine_lexen@challando.com", DigestUtils.sha256Hex("Madeleine123"));
        customerDAO.register_customer_signup("philip_hellberg@challando.com", DigestUtils.sha256Hex("Philip123"));
    }

    @Override
    public CredentialValidationResult validate(Credential credential1) {
        UsernamePasswordCredential credential = (UsernamePasswordCredential) credential1;
        String username = credential.getCaller();
        String password = credential.getPasswordAsString();

        if (customerDAO.is_registered_Customer(username, password)) {
            return new CredentialValidationResult(credential.getCaller());
        }
        return INVALID_RESULT;
    }

}
