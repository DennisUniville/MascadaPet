package br.com.mascada;

import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/rest")
public class ApplicationConfig extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		return getRestResourceClasses();
	}

	private Set<Class<?>> getRestResourceClasses() {
		Set<Class<?>> resources = new java.util.HashSet<Class<?>>();
		resources.add(ClienteREST.class);
		return resources;
	}
}
