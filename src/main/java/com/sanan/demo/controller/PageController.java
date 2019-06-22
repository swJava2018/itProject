package com.sanan.demo.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.social.google.connect.GoogleOAuth2Template;
import org.springframework.social.oauth2.GrantType;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class PageController {

	private final String clientId = "205834302052-jn3qaoq9v9o9l85m4eabg0os8k1ejem0.apps.googleusercontent.com";
	private final String clientSecret = "cZY3COcWY-kjWBt1V2KkDWYD";
	
//	@Autowired
    private GoogleOAuth2Template googleOAuth2Template 
    	= new GoogleOAuth2Template(clientId, clientSecret);
    
//    @Autowired
    private OAuth2Parameters googleOAuth2Parameters
    	= getOAuth2Params();
    
    private static OAuth2Parameters getOAuth2Params() {
    	OAuth2Parameters params = new OAuth2Parameters();
    	params.setScope("profile");
    	params.setRedirectUri("http://localhost:8080/googleSignInCallback");
    	return params;
    }	
    
	@RequestMapping(value = {"", "/"}, method = {RequestMethod.GET, RequestMethod.POST})
	public String join(Model model) {
		String url = googleOAuth2Template.buildAuthenticateUrl(GrantType.AUTHORIZATION_CODE, googleOAuth2Parameters);
        System.out.println("/googleLogin, url : " + url);
        model.addAttribute("google_url", url);
        
		return "index_google";
	}
	
	@RequestMapping(value = {"/googleSignInCallback"}, method = {RequestMethod.GET, RequestMethod.POST})
	public String doSessionAssignActionPage(HttpServletRequest request) {
		String code = request.getParameter("code");
        System.out.println(code);
        
        //RestTemplate을 사용하여 Access Token 및 profile을 요청한다.
        RestTemplate restTemplate = new RestTemplate();
        MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
        parameters.add("code", code);
        parameters.add("client_id", clientId);
        parameters.add("client_secret", clientSecret);
        parameters.add("redirect_uri", googleOAuth2Parameters.getRedirectUri());
        parameters.add("grant_type", "authorization_code");
 
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<MultiValueMap<String, String>>(parameters, headers);
        ResponseEntity<Map> responseEntity = restTemplate.exchange("https://www.googleapis.com/oauth2/v4/token", HttpMethod.POST, requestEntity, Map.class);
        Map<String, Object> responseMap = responseEntity.getBody();
 
        // id_token 라는 키에 사용자가 정보가 존재한다.
        // 받아온 결과는 JWT (Json Web Token) 형식으로 받아온다. 콤마 단위로 끊어서 첫 번째는 현 토큰에 대한 메타 정보, 두 번째는 우리가 필요한 내용이 존재한다.
        // 세번째 부분에는 위변조를 방지하기 위한 특정 알고리즘으로 암호화되어 사이닝에 사용한다.
        //Base 64로 인코딩 되어 있으므로 디코딩한다.
 
        String[] tokens = ((String)responseMap.get("id_token")).split("\\.");
        Base64 base64 = new Base64(true);
        String body = new String(base64.decode(tokens[1]));
        
        try {
	        System.out.println(tokens.length);
	        System.out.println(new String(Base64.decodeBase64(tokens[0]), "utf-8"));
	        System.out.println(new String(Base64.decodeBase64(tokens[1]), "utf-8"));
        
        
	        //Jackson을 사용한 JSON을 자바 Map 형식으로 변환
	        ObjectMapper mapper = new ObjectMapper();
	        Map<String, String> result = mapper.readValue(body, Map.class);
	        System.out.println(result.get(""));
        
        
        } catch(UnsupportedEncodingException e) {
        	e.printStackTrace();
        } catch(IOException e) {
        	e.printStackTrace();
        }
        return "redirect:/index_google";
	}
	
//	@Autowired
//	UserService userService;
//	
//	private static final String SESSION_ID = "user_id";
//	private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//
//	
//	@RequestMapping(value = {"", "/", "/index"}, method = {RequestMethod.GET})
//	public String index(HttpSession session) {
//		if (session.getAttribute(SESSION_ID) == null) {
//			return "login";
//		}
//		
//		return "index";
//	}
//	
//	@RequestMapping(value="/logout", method = {RequestMethod.GET})
//	public String logout(HttpSession session) {
//		session.removeAttribute(SESSION_ID);
//		return "login";
//	}
//	
//	@RequestMapping(value="/login", method = {RequestMethod.POST})
//	public ModelAndView loginPost(Login login, HttpSession session) throws SananException {
//		session.removeAttribute(SESSION_ID);
//		
//		ModelAndView modelAndView;
//		
//		User selected_user = userService.selectUser(login.getId());
//		if(selected_user == null) 
//			throw new SananException(SananErrorCode.USER_NOT_FOUND);		
//		
//		if (passwordEncoder.matches(login.getPassword(), selected_user.getPassword())) {
//			modelAndView = new ModelAndView("redirect:index");
//			session.setAttribute(SESSION_ID, login.getId());
//			return modelAndView;
//			
//		} else {
//			throw new SananException(SananErrorCode.USER_LOGIN_FAIL);
//		}
//	}
//	
//	@RequestMapping(value = "/login", method = {RequestMethod.GET})
//	public ModelAndView login(HttpSession session) {		
//		ModelAndView modelAndView;		
//		if (session.getAttribute(SESSION_ID) != null) {
//			modelAndView = new ModelAndView("redirect:index");
//			return modelAndView;
//		}
//		
//		modelAndView = new ModelAndView("login");
//		return modelAndView;
//	}
//	
//	@RequestMapping(value="/enroll", method = {RequestMethod.POST})
//	public ModelAndView enrollPost(Enroll enroll, HttpSession session) throws SananException {
//		session.removeAttribute(SESSION_ID);
//		
//		ModelAndView modelAndView;
//		
//		User user = new User();
//		user.setId(enroll.getId());
//		user.setPassword(passwordEncoder.encode(enroll.getPwd()));					
//		userService.insertUser(user);
//		modelAndView = new ModelAndView("redirect:index");
//		session.setAttribute(SESSION_ID, enroll.getId());
//		return modelAndView;
//	}
//	
//	@RequestMapping(value = "/enroll", method = {RequestMethod.GET})
//	public String enroll(Model model) {
//		return "enroll";
//	}
//	
//	@ExceptionHandler(SananException.class)
//	public ModelAndView handleAllException(HttpServletRequest request, SananException e) {
//		String view = request.getRequestURI().replace("/", "");
//		ModelAndView modelAndView = new ModelAndView(view);
//		modelAndView.addObject("error", e.getMessage());
//		return modelAndView;
//	}
//	
//	@ExceptionHandler(Exception.class)
//	public ModelAndView handleAllException(Exception e) {
//		ModelAndView modelAndView = new ModelAndView("error");
//		modelAndView.addObject("error", SananErrorCode.getErrorMessage(SananErrorCode.INTERNAL_ERROR));
//		return modelAndView;
//	}
}
