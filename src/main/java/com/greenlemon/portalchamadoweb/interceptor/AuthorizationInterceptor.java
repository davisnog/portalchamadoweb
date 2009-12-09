package com.greenlemon.portalchamadoweb.interceptor;

import static br.com.caelum.vraptor.view.Results.logic;

import java.lang.reflect.Method;

import br.com.caelum.vraptor.InterceptionException;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.interceptor.Interceptor;
import br.com.caelum.vraptor.resource.ResourceMethod;

import com.greenlemon.portalchamadoweb.controller.HomeController;
import com.greenlemon.portalchamadoweb.controller.UsersController;
import com.greenlemon.portalchamadoweb.dao.UserDao;
import com.greenlemon.portalchamadoweb.model.Corporation;
import com.greenlemon.portalchamadoweb.model.Individual;
import com.greenlemon.portalchamadoweb.model.Role;
import com.greenlemon.portalchamadoweb.model.ServiceProvider;

@Intercepts
public class AuthorizationInterceptor implements Interceptor {

	private final UserInfo info;
	private final UserDao dao;
	private final Result result;

	public AuthorizationInterceptor(UserInfo info, UserDao dao, Result result) {
		this.info = info;
		this.dao = dao;
		this.result = result;
	}

    public boolean accepts(ResourceMethod method) {
        return notLogin(method) && notNewUser(method);
    }

    private boolean notNewUser(ResourceMethod method) {
        Method invokedMethod = method.getMethod();
        if (invokedMethod.getDeclaringClass().equals(UsersController.class)) {
            return !"add".equals(invokedMethod.getName()) && !"userAdded".equals(invokedMethod.getName());
        }
        return true;
    }

    private boolean notLogin(ResourceMethod method) {
        return !method.getMethod().getDeclaringClass().equals(HomeController.class);
    }

    public void intercept(InterceptorStack stack, ResourceMethod method, Object resourceInstance)
            throws InterceptionException {
    	
    	if (info.getUser() == null) {
    		result.use(logic()).redirectTo(HomeController.class).login();
    	} else {
	    	dao.refresh(info.getUser());
	    	
	    	Role role = info.getUser().getRole();
			
			if(role == Role.ADMINISTRATOR){
				result.include("adm", "administrator");
			}else if(role == Role.SERVICE_PROVIDER){
				result.include("ser", "serviceProvider");
			}
			else if(role == Role.CUSTOMER){
				result.include("cus", "customer");
			}
			
			ServiceProvider serviceProvider = info.getUser().getServiceProvider();
			
			if(serviceProvider != null){
			
				Corporation corp = serviceProvider.getCorporation();
				
				if(corp != null){
					result.include("corporation", corp);
				}else{
					
					Individual ind = serviceProvider.getIndividual();
					
					if(ind != null){
						result.include("individual", ind);
					}
				}
			}

	    	stack.next(method, resourceInstance);
    	}
    }
}
