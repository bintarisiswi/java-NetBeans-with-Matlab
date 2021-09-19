/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myf;

/**
 *
 * @author bintari
 */
import java.util.logging.Level;
import java.util.logging.Logger;
import matlabcontrol.MatlabConnectionException;
import matlabcontrol.MatlabInvocationException;
import matlabcontrol.MatlabProxy;
import matlabcontrol.MatlabProxyFactory;
import matlabcontrol.MatlabProxyFactoryOptions;
import matlabcontrol.extensions.MatlabTypeConverter;

/**
*
* @author bintari
*/
public class Myf {

/**
* @param args the command line arguments
* @throws matlabcontrol.MatlabConnectionException
* @throws matlabcontrol.MatlabInvocationException
*/
    
    
    public static void main(String[] args) throws MatlabConnectionException, MatlabInvocationException{
    // TODO code application logic here
        try{
            MatlabProxyFactoryOptions options=new MatlabProxyFactoryOptions.Builder().setUsePreviouslyControlledSession(true).build();
            MatlabProxyFactory factory=new MatlabProxyFactory(options);
            MatlabProxy proxy = factory.getProxy();
            MatlabTypeConverter processor=new MatlabTypeConverter(proxy);

            proxy.eval("addpath('C:\\Users\\user\\Documents\\NetBeansProjects\\myf')");
            proxy.eval("funct1()");
            proxy.eval("rmpath('C:\\Users\\user\\Documents\\NetBeansProjects\\myf')");
            proxy.disconnect();

        }catch (MatlabInvocationException ex){
            Logger.getLogger(Myf.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
