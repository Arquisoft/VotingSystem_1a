package es.uniovi.asw.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/")
public class ControllerLogin {

	private static final Logger LOG = LoggerFactory.getLogger(ControllerLogin.class);

	@RequestMapping(method = RequestMethod.GET)
	public RedirectView localRedirect() {
<<<<<<< HEAD
	  	LOG.info("Launching Application");
	    RedirectView redirectView = new RedirectView();
	    redirectView.setUrl("/login.xhtml");
	    return redirectView;
=======
		LOG.info("Launching Application");
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl("./login.xhtml");
		return redirectView;
>>>>>>> master
	}

}