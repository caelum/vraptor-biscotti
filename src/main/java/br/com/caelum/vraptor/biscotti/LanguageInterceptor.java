package br.com.caelum.vraptor.biscotti;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import br.com.caelum.vraptor.BeforeCall;
import br.com.caelum.vraptor.environment.Environment;

public class LanguageInterceptor {

	private Cookie cookie;
	private HttpServletRequest http;
	private Request request;
	private Environment env;
	private Application app;

	/** @deprecated cdi */
	LanguageInterceptor() {
	}

	@Inject
	public LanguageInterceptor(Cookie cookie, HttpServletRequest req,
			Request request, Environment env, Application app) {
		this.cookie = cookie;
		this.http = req;
		this.request = request;
		this.env = env;
		this.app = app;
	}

	@BeforeCall
	public void change() {
		if (http.getParameter("_language") != null) {
			cookie.set(http.getParameter("_language"));
		}
		if (http.getParameter("__language") != null) {
			request.set(http.getParameter("__language"));
		}
		if (http.getParameter("___language") != null
				&& !env.getName().equals("production")) {
			app.set(http.getParameter("___language"));
		}
	}

}
