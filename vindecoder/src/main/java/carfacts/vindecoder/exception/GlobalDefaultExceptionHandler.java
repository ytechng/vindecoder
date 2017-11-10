package carfacts.vindecoder.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {

	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handleNoHandlerFoundException() {
		
		ModelAndView mv  = new ModelAndView("error");
		
		mv.addObject("errorTitle", "The page is not constructed!");
		mv.addObject("errorDesc", "The page you are looking for is presently not available!");
		mv.addObject("title", "404 Error Page");
		mv.addObject("userClickException", true);
		
		return mv;
	}
}
