package com.mars.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mars.exceptionhandler.CustomGenericException;
import com.mars.model.Address;
import com.mars.model.Person;
import com.mars.service.PersonService;

/**
 * This is the Controller class manages the Create/Read/Update/Delete function
 * 
 * @author Sreenivas Vadloju
 *
 */
@RequestMapping(value="/usermanagement")
@Controller
public class PersonController {

	private static final Logger logger = Logger.getLogger(PersonController.class);

	@Autowired
	private PersonService personService;
	
	public static final String PERSONS_NOT_FOUND="No Users found in the System";


	/**
	 * Fetches the list of persons.
	 * 
	 * @param model
	 * @return ModelAndView
	 * @throws Exception 
	 */
	@RequestMapping(value = "/home")
	public ModelAndView getAllPersons(ModelAndView model) throws Exception{
		List<Person> personList;
		try {
			personList = personService.getAllPersons();
			model.addObject("personList", personList);
			model.setViewName("home");
		} catch (Exception ex) {
			if (ex instanceof CustomGenericException) {
				model.setViewName("home");
				model.addObject("errMsg", ((CustomGenericException) ex).getErrMsg());
			}else {
				throw new Exception();
			}
		}
		return model;	
	}
	
	/**
	 * Redirects the user to add a new person.
	 * @param model
	 * @return model
	 */
	@RequestMapping(value = "/newPerson", method = RequestMethod.GET)
	public ModelAndView newPerson(ModelAndView model) throws Exception{
		try {
			Person person = new Person();
			model.addObject("person", person);
			model.setViewName("addPerson");
			}catch (Exception ex) {
				if (ex instanceof CustomGenericException) {
					model.setViewName("addPerson");
					model.addObject("errMsg", ((CustomGenericException) ex).getErrMsg());
				}else {
					throw new Exception();
				}
			}
			return model;	
	}
	
	/**
	 * This method saves Person details into database. 
	 * @param person
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/savePerson", method = RequestMethod.POST)
	public ModelAndView savePerson(@ModelAttribute @Valid Person person,BindingResult result) throws Exception{
		try {
			if(result.hasErrors()) {
		    	    return new ModelAndView("addPerson");
		        }
		 	if (person.getId() == 0) {
				personService.addPerson(person);
			} else {
				personService.updatePerson(person);
			}
		}catch (Exception ex) {
				if (ex instanceof CustomGenericException) {
					ModelAndView model = new ModelAndView();
					model.setViewName("addPerson");
					model.addObject("errMsg", ((CustomGenericException) ex).getErrMsg());
				}else {
					throw new Exception();
				}
			}
			return new ModelAndView("redirect:/usermanagement/home");
				
	}
	
	/**
	 * This method deletes Person details. 
	 * @param request
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/deletePerson", method = RequestMethod.GET)
	public ModelAndView deletePerson(HttpServletRequest request) throws Exception{
		try {
			long personId = Long.parseLong(request.getParameter("id"));
			personService.deletePerson(personId);
		}catch (Exception ex) {
				if (ex instanceof CustomGenericException) {
					ModelAndView model = new ModelAndView();
					model.setViewName("home");
					model.addObject("errMsg", ((CustomGenericException) ex).getErrMsg());
				}else {
					throw new Exception();
				}
			}
		return new ModelAndView("redirect:/usermanagement/home");
	}
	
	/**
	 * This method redirects the user to edit the Person details. 
	 * @param request
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/editPerson", method = RequestMethod.GET)
	public ModelAndView editPerson(HttpServletRequest request)  throws Exception{
		
		ModelAndView model = new ModelAndView();
		try {
			long personId = Long.parseLong(request.getParameter("id"));
			Optional<Person> person = personService.getPerson(personId);
			model.setViewName("addPerson");
			model.addObject("person", person);
		}catch (Exception ex) {
			if (ex instanceof CustomGenericException) {
				ModelAndView model1 = new ModelAndView();
				model1.setViewName("addPerson");
				model1.addObject("errMsg", ((CustomGenericException) ex).getErrMsg());
			}else {
				throw new Exception();
			}
		}
		return model;
	}
	
	/**
	 * This method Person and Address details.
	 * @param model
	 * @param request
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/viewPersonAddress", method = RequestMethod.GET)
	public ModelAndView viewPersonAddress(ModelAndView model,HttpServletRequest request)  throws Exception{
		try {
				long personId = Long.parseLong(request.getParameter("id"));
				List<Address> listAddress = personService.getAllAddressForPerson(personId);
				model.addObject("listAddress", listAddress);		
				Optional<Person> person1 = personService.getPerson(personId);
				Person person = person1.get();
				model.setViewName("personDetails");
				model.addObject("person", person);
		}catch (Exception ex) {
				if (ex instanceof CustomGenericException) {
					ModelAndView model1 = new ModelAndView();
					model1.setViewName("addPerson");
					model1.addObject("errMsg", ((CustomGenericException) ex).getErrMsg());
				}else {
					throw new Exception();
				}
		}
			return model;
	}
	
	/**
	 * This method add new address. 
	 * @param model
	 * @param request
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/addAddress", method = RequestMethod.GET)
	public ModelAndView addAddress(ModelAndView model,HttpServletRequest request) throws Exception{
		try {
			long personId = Long.parseLong(request.getParameter("id"));
			Optional<Person> person1 = personService.getPerson(personId);
			Person person = person1.get();
			Address address = new Address();
			address.setPerson(person);
			model.addObject("address", address);
			model.addObject("person", person);
			model.setViewName("addAddress");		
		}catch (Exception ex) {
				if (ex instanceof CustomGenericException) {
					ModelAndView model1 = new ModelAndView();
					model1.setViewName("addPerson");
					model1.addObject("errMsg", ((CustomGenericException) ex).getErrMsg());
				}else {
					throw new Exception();
				}
		}
		return model;
	}
	
	/**
	 * This method saves Address details. 
	 * @param address
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/saveAddress", method = RequestMethod.POST)
	public ModelAndView saveAddress(@ModelAttribute @Valid Address address,BindingResult result) throws Exception{
		try {
			if(result.hasErrors()) {
		    	    return new ModelAndView("addAddress");
		     }
			long personId = address.getPerson().getId();
			Optional<Person> person1 = personService.getPerson(personId);
			Person person = person1.get();
			Set<Address> addressSet=new HashSet<Address>();
			addressSet.add(address);
			person.setAddressList(addressSet);			
			if (address.getId() == 0) { 
				personService.addAddress(person);
			} else {
				personService.updateAddress(person);
			}
		}catch (Exception ex) {
				if (ex instanceof CustomGenericException) {
					ModelAndView model1 = new ModelAndView();
					model1.setViewName("addAddress");
					model1.addObject("errMsg", ((CustomGenericException) ex).getErrMsg());
				}else {
					throw new Exception();
				}
		}	
		return new ModelAndView("redirect:/usermanagement/home");
	}
	
	/**
	 * This method redirects the user to edit the Address details. 
	 * @param request
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/editAddress", method = RequestMethod.GET)
	public ModelAndView editAddress(HttpServletRequest request) throws Exception{
		ModelAndView model = new ModelAndView("addAddress");
		try {		
			int addressId = Integer.parseInt(request.getParameter("id"));
			Optional<Address> address1= personService.getAddress(addressId);
			Address address = address1.get();
			model.setViewName("addAddress");			
			model.addObject("address", address);
		  }	catch (Exception ex) {
				if (ex instanceof CustomGenericException) {
					ModelAndView model1 = new ModelAndView();
					model1.setViewName("addAddress");
					model1.addObject("errMsg", ((CustomGenericException) ex).getErrMsg());
				}else {
					throw new Exception();
				}
		  }	
		return model;
	}
	
	/**
	 * This method deletes Address details. 
	 * @param request
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/deleteAddress", method = RequestMethod.GET)
	public ModelAndView deleteAddress(HttpServletRequest request) throws Exception{
		try {		
			int addressId = Integer.parseInt(request.getParameter("id"));
			personService.deleteAddress(addressId);
			
		}catch (Exception ex) {
				if (ex instanceof CustomGenericException) {
					ModelAndView model1 = new ModelAndView();
					model1.setViewName("addAddress");
					model1.addObject("errMsg", ((CustomGenericException) ex).getErrMsg());
				}else {
					throw new Exception();
				}
		  }		
		return new ModelAndView("redirect:/usermanagement/home");
	}
	
	
	
	

}