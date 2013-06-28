
package com.walmart.ecomm.services.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import com.sun.jersey.client.urlconnection.HTTPSProperties;
import java.security.GeneralSecurityException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.text.MessageFormat;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.ws.rs.core.MediaType;

/** 
 *
 * @author vrangan
 */
public class GenericServiceClient implements ServiceClientInterface {
    private WebResource webResource;
    private Client client;
    
    public GenericServiceClient(String baseURI, String resource) {
        ClientConfig config = new DefaultClientConfig(); // SSL configuration
        config.getProperties().put(HTTPSProperties.PROPERTY_HTTPS_PROPERTIES, new HTTPSProperties(getHostnameVerifier(), getSSLContext()));
        client = Client.create(config);
        webResource = client.resource(baseURI).path(resource);
    }

    
    public <T> T findAll_JSON(Class<T> responseType) throws UniformInterfaceException {
        WebResource resource = webResource;
        return resource.accept(MediaType.APPLICATION_JSON).get(responseType);
    }

  
  
    public void edit_JSON(Object requestEntity) throws UniformInterfaceException {
        webResource.type(MediaType.APPLICATION_JSON).put(requestEntity);
    }

   
    
    public void create_JSON(Object requestEntity) throws UniformInterfaceException {
        webResource.type(MediaType.APPLICATION_JSON).post(requestEntity);
    }

    
    public <T> T find_JSON(Class<T> responseType, String id) throws UniformInterfaceException {
        WebResource resource = webResource;
        resource = resource.path(MessageFormat.format("{0}", new Object[]{id}));
        return resource.accept(MediaType.APPLICATION_JSON).get(responseType);
    }

    public void close() {
        client.destroy();
    }

    public void setUsernamePassword(String username, String password) {
        client.addFilter(new HTTPBasicAuthFilter(username, password));
    }

    private HostnameVerifier getHostnameVerifier() {
        return new HostnameVerifier() {
           
            public boolean verify(String hostname, SSLSession sslSession) {
                return true;
            }
        };
    }

    private SSLContext getSSLContext() {
        TrustManager x509 = new X509TrustManager() {
           
            public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
                //Test whether its a Trusted Client
            }

            
            public void checkServerTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
                //Test whether its a Trusted Server
            }

            
            public X509Certificate[] getAcceptedIssuers() {
                //return the Certificate
                return null;
            }
        };
        SSLContext ctx = null;
        try {
            ctx = SSLContext.getInstance("SSL");
            ctx.init(null, new TrustManager[]{x509}, null);
        } catch (GeneralSecurityException ex) {
            //Log the Exceptions
        }
        return ctx;
    }
    
}
