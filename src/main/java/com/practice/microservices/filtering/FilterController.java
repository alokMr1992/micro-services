package com.practice.microservices.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilterController {

	@GetMapping("/filtering")
	public MappingJacksonValue retrieveBean() {
		FilterBean bean = new FilterBean("1", "Alok", 27);

		SimpleBeanPropertyFilter propertyFilter = SimpleBeanPropertyFilter.filterOutAllExcept("id", "name");
		FilterProvider provider = new SimpleFilterProvider().addFilter("beanFilter", propertyFilter);
		MappingJacksonValue jacksonValue = new MappingJacksonValue(bean);
		jacksonValue.setFilters(provider);
		
		return jacksonValue;
	}

	@GetMapping("/filtering-list")
	public MappingJacksonValue retrieveListBean() {
		List<FilterBean> listOfBean = Arrays.asList(new FilterBean("1", "Alok", 27), new FilterBean("2", "Jhamura", 25));
		
		SimpleBeanPropertyFilter propertyFilter = SimpleBeanPropertyFilter.filterOutAllExcept("name", "age");
		FilterProvider provider = new SimpleFilterProvider().addFilter("beanFilter", propertyFilter);
		MappingJacksonValue jacksonValue = new MappingJacksonValue(listOfBean);
		jacksonValue.setFilters(provider);
		
		return jacksonValue;
	}
}