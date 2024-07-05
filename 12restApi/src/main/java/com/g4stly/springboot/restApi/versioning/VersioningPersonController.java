package com.g4stly.springboot.restApi.versioning;

import org.springframework.web.bind.annotation.*;


@RestController
public class VersioningPersonController {
	
	//! VERSIONING WITH URL
	@GetMapping("/v1/person")
	public PersonV1 getFirstVersionOfPerson() {
		return new PersonV1("Bob Charlie");
	}

	@GetMapping("/v2/person")
	public PersonV2 getSecondVersionOfPerson() {
		return new PersonV2(new Name("Bob","Charlie"));
	}
	
	//! VERSIONING WITH REQUEST PARAMETERS
	@GetMapping(path="/person", params="version=1")
	public PersonV1 getFirstVersionOfPersonRequestParameter() {
		return new PersonV1("Bob Charlie");
	}
	@GetMapping(path="/person", params="version=2")
	public PersonV2 getSecondVersionOfPersonRequestParameter() {
		return new PersonV2(new Name("Bob","Charlie"));
	}
	
	//! VERSIONING WITH REQUEST HEADERS
	@GetMapping(path="/person", headers="X-API-VERSION=1")
	public PersonV1 getFirstVersionOfPersonRequestHeader() {
		return new PersonV1("Bob Charlie");
	}
	@GetMapping(path="/person", headers="X-API-VERSION=2")
	public PersonV2 getSecondVersionOfPersonRequestHeader() {
		return new PersonV2(new Name("Bob","Charlie"));
	}
	
}
