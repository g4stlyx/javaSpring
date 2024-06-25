package com.g4stly.springboot.webApp1.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {
	
	@RequestMapping("say-hello")
	@ResponseBody // = bu fonksiyon ne dönüyorsa url'de onu göster
	public String sayHello() {
		return "Hello Java Spring Boot!";
	}

	@RequestMapping("say-hello-html")
	@ResponseBody
	public String sayHelloHtml() {
		StringBuffer sb = new StringBuffer();
		sb.append("<html><head><title>Title</title></head><body>her satırı tek tek append etme yoluyla html yazdırılabilir, tabii ki bunu göstermicem</body></html>");
		return sb.toString();
	}
	
	
}
