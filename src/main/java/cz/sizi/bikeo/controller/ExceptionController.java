package cz.sizi.bikeo.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import cz.sizi.bikeo.exception.CustomGenericException;

@ControllerAdvice
public class ExceptionController {
		
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
		ModelAndView model = new ModelAndView("genericError");
		model.addObject("errCode", ex.getErrCode());
		model.addObject("errMsg", ex.getErrMsg());
		return model;
	}
	
	//exception.class - vsechny chyby serveru
	@ExceptionHandler(Exception.class)
	public ModelAndView handleAllExceptions(Exception ex) {
		ex.printStackTrace();
		ModelAndView model = new ModelAndView("genericError");
		model.addObject("errCode", "500");
		model.addObject("errMsg", "Internal server error - omlouvame se za nami zpusobene potize.");
		return model;
	}
	
	//pokryva 404 - uzivatel zadal chybnou stranku na domene bikeo.cz
	@ExceptionHandler(NoHandlerFoundException.class)
    public ModelAndView handleError404(Exception e)   {
            ModelAndView model = new ModelAndView("genericError");
            model.addObject("errCode", "404");
            model.addObject("errMsg", "Zadana stranka nebyla na serveru bikeo.cz nalezena");
            return model;
    }
}
