package br.com.caelum.vraptor.biscotti;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Application implements LanguageScope {

	private String language = "";

	public void set(String language) {
		this.language = language;
	}

	public String get() {
		return language;
	}
}
