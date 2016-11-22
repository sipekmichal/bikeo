package cz.sizi.bikeo.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import cz.sizi.bikeo.exception.CustomGenericException;

@ControllerAdvice
public class ExceptionController {
	
	private static final Logger logger = LoggerFactory.getLogger(ExceptionController.class);
	
//	@RequestMapping(value = "/{type:.+}", method = RequestMethod.GET)
//	public ModelAndView getPages(@PathVariable("type") String type)
//		throws Exception {
//
//	  if ("error".equals(type)) {
//		// go handleCustomException
//		throw new CustomGenericException("E888", "This is custom message");
//	  } else if ("io-error".equals(type)) {
//		// go handleAllException
//		throw new IOException();
//	  } else {
//		return new ModelAndView("index").addObject("msg", type);
//	  }
//	}
	
	//custom message - pro budouci mozne pouziti
	@ExceptionHandler(CustomGenericException.class)
	public ModelAndView handleCustomException(CustomGenericException ex) {
		ex.printStackTrace();
		ModelAndView model = new ModelAndView("GenericError");
		model.addObject("errCode", ex.getErrCode());
		model.addObject("errMsg", ex.getErrMsg());
		return model;
	}
	
	//exception.class - vsechny chyby serveru
	@ExceptionHandler(Exception.class)
	public ModelAndView handleAllExceptions(Exception ex) {
		ex.printStackTrace();
		ModelAndView model = new ModelAndView("GenericError");
		model.addObject("errCode", "500");
		model.addObject("errMsg", "Internal server error - omlouváme se za námi zpùsobené potíže.");
		return model;
	}
	
	//pokryva 404 - uzivatel zadal chybnou stranku na domene bikeo.cz
	@ExceptionHandler(NoHandlerFoundException.class)
    public ModelAndView handleError404(Exception e)   {
            ModelAndView model = new ModelAndView("GenericError");
            model.addObject("errCode", "404");
            model.addObject("errMsg", "Zadaná stránka nebyla na serveru bikeo.cz nalezena");
            return model;
    }
}
