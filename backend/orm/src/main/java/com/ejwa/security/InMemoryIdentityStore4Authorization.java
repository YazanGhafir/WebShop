package com.ejwa.security;


import javax.enterprise.context.ApplicationScoped;
import javax.security.enterprise.identitystore.CredentialValidationResult;
import javax.security.enterprise.identitystore.IdentityStore;
import java.util.*;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.security.enterprise.authentication.mechanism.http.BasicAuthenticationMechanismDefinition;
import javax.security.enterprise.authentication.mechanism.http.CustomFormAuthenticationMechanismDefinition;
import javax.security.enterprise.authentication.mechanism.http.LoginToContinue;
import javax.security.enterprise.credential.Credential;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import static javax.security.enterprise.identitystore.CredentialValidationResult.INVALID_RESULT;

@RequestScoped
/*@CustomFormAuthenticationMechanismDefinition(
        loginToContinue = @LoginToContinue(
                loginPage = "/login.xhtml",
                errorPage = "/login-error.html"
      )*/

class InMemoryIdentityStore4Authorization implements IdentityStore {

    private Map<String, List<String>> userRoles = new HashMap<>();
    private Map<String, String> users = new HashMap<>();
    

    @PostConstruct
    private void init() {
         //user1
        users.put("user", "pass0");
        //user2
        users.put("admin", "pass1");
        
        //user1
        List<String> roles = new ArrayList<>();
        roles.add("USER_ROLE");
        userRoles.put("user", roles);
        //user2
        roles = new ArrayList<>();
        roles.add("USER_ROLE");
        roles.add("ADMIN_ROLE");
        userRoles.put("admin", roles);
    }

    /*@Override
    public int priority() {
        return 1;
    }

    @Override
    public Set<ValidationType> validationTypes() {
        System.out.println("typeHerererere%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        return EnumSet.of(ValidationType.VALIDATE);
    }*/

    @Override
    public Set<String> getCallerGroups(CredentialValidationResult validationResult) {
        System.out.println("callergroupHerererere%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        List<String> roles = userRoles.get(validationResult.getCallerPrincipal().getName());
        return new HashSet<>(roles);
    }
    
    /*
    public CredentialValidationResult validate(UsernamePasswordCredential credential) {
        String password = users.get(credential.getCaller());
        if (password != null && password.equals(credential.getPasswordAsString())) {
            return new CredentialValidationResult(credential.getCaller());
        }
        return INVALID_RESULT;
    }
*/
    @Override
    public  CredentialValidationResult validate(Credential credential1) {
        System.out.println("validateHerererere%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        UsernamePasswordCredential credential = (UsernamePasswordCredential) credential1;
        String password = users.get(credential.getCaller());
        if (password != null && password.equals(credential.getPasswordAsString())) {
            System.out.println("PASSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            return new CredentialValidationResult(credential.getCaller());
        }
        return INVALID_RESULT;
    }
 
}
