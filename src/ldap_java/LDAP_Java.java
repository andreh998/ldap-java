/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ldap_java;

import java.util.Hashtable;
import javax.naming.AuthenticationException;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
/**
 *
 * @author andreh3037_00
 */
public class LDAP_Java {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LDAP_Java ldap = new LDAP_Java();
        ldap.auticaLogin("user", "senha@123");
    }
    
    public static void auticaLogin(String usuario, String senha) {
        Hashtable authEnv = new Hashtable(11);
        authEnv.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        authEnv.put(Context.PROVIDER_URL, "ldap://dominio.com.br");
        authEnv.put(Context.SECURITY_AUTHENTICATION, "simple" );
        authEnv.put(Context.SECURITY_PRINCIPAL, usuario + "@dominio.com.br" );
        authEnv.put(Context.SECURITY_CREDENTIALS, senha);

        try {
            DirContext authContext = new InitialDirContext(authEnv);

            System.out.println("Autenticado!" );
        } catch (AuthenticationException authEx) {

            System.out.println("Erro na autenticação! " );
            authEx.getCause().printStackTrace();
        } catch (NamingException namEx) {
            System.out.println("Problemas na conexão! " );
            namEx.getCause().printStackTrace();
        }
    }
    
}
