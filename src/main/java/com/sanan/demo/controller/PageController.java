package com.sanan.demo.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.social.MissingAuthorizationException;
import org.springframework.social.connect.Connection;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.UserOperations;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;
import org.springframework.social.google.connect.GoogleOAuth2Template;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.GrantType;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class PageController {

	/**
	 * Facebook OAuth2
	 */
	private final String facebookAppId = "910683312657246";
	private final String facebookAppSecret = "19e88a6e9c545f32755fd6f87dd2fc37";
	
    private FacebookConnectionFactory connectionFactory = new FacebookConnectionFactory(facebookAppId, facebookAppSecret);

    private OAuth2Parameters oAuth2ParametersForFaceBook = getOAuth2ParamsForFaceBook();

    private static OAuth2Parameters getOAuth2ParamsForFaceBook() {
    	OAuth2Parameters params = new OAuth2Parameters();
    	params.setScope("email");
    	params.setRedirectUri("https://localhost:9443/facebookSignInCallback");
    	return params;
    }	
    
	/**
	 * Naver OAuth
	 */
	private final String nclientId = "PrhV1w49TZbmWr6NJ51a";
	private final String nclientSecret = "CA969ikOpO";
	private final String nRedirectUrl = "http://localhost:8080/naverSignInCallback";
	
	
	/**
	 * Google OAuth
	 */
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
		
		/**
		 * facebook url
		 */
		OAuth2Operations oauthOperations = connectionFactory.getOAuthOperations();
        String facebook_url = oauthOperations.buildAuthorizeUrl(GrantType.AUTHORIZATION_CODE, oAuth2ParametersForFaceBook);
        
        System.out.println("/facebookLogin, url : " + facebook_url);
        model.addAttribute("facebook_url", facebook_url);
		
		
		/**
		 * google url
		 */
		String url = googleOAuth2Template.buildAuthenticateUrl(GrantType.AUTHORIZATION_CODE, googleOAuth2Parameters);
        System.out.println("/googleLogin, url : " + url);
        model.addAttribute("google_url", url);
        
        /**
         * naver url 
         */
        String apiURL = "https://nid.naver.com/oauth2.0/authorize?response_type=code";
        try {
	        String redirectURI = URLEncoder.encode(nRedirectUrl, "UTF-8");
	        SecureRandom random = new SecureRandom();
	        String state = new BigInteger(130, random).toString();
	        apiURL += "&client_id=" + nclientId;
	        apiURL += "&redirect_uri=" + redirectURI;
	        apiURL += "&state=" + state;
        } catch (Exception e) {
        	e.printStackTrace();
        }
        model.addAttribute("naver_url", apiURL);
        
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
	
	@RequestMapping(value = {"/naverSignInCallback"}, method = {RequestMethod.GET, RequestMethod.POST})
	public String doSessionAssignActionPage2(HttpServletRequest request) {
		try {
		    String code = request.getParameter("code");
		    String state = request.getParameter("state");
		    String redirectURI = URLEncoder.encode(nRedirectUrl, "UTF-8");
		    String apiURL;
		    apiURL = "https://nid.naver.com/oauth2.0/token?grant_type=authorization_code&";
		    apiURL += "client_id=" + nclientId;
		    apiURL += "&client_secret=" + nclientSecret;
		    apiURL += "&redirect_uri=" + redirectURI;
		    apiURL += "&code=" + code;
		    apiURL += "&state=" + state;
		    String access_token = "";
		    String refresh_token = "";
		    System.out.println("apiURL="+apiURL);
	    
	      URL url = new URL(apiURL);
	      HttpURLConnection con = (HttpURLConnection)url.openConnection();
	      con.setRequestMethod("GET");
	      int responseCode = con.getResponseCode();
	      BufferedReader br;
	      System.out.print("responseCode="+responseCode);
	      if(responseCode==200) { // 정상 호출
	        br = new BufferedReader(new InputStreamReader(con.getInputStream()));
	      } else {  // 에러 발생
	        br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
	      }
	      String inputLine;
	      StringBuffer res = new StringBuffer();
	      while ((inputLine = br.readLine()) != null) {
	        res.append(inputLine);
	      }
	      br.close();
	      if(responseCode==200) {
	    	  System.out.println(res.toString());
	      }
	    } catch (Exception e) {
	      System.out.println(e);
	    }

	    
        return "redirect:/index_google";
	}
	
	@RequestMapping(value = "/facebookSignInCallback", method = { RequestMethod.GET, RequestMethod.POST })
    public String facebookSignInCallback(@RequestParam String code) throws Exception {
 
        try {
             String redirectUri = oAuth2ParametersForFaceBook.getRedirectUri();
            System.out.println("Redirect URI : " + redirectUri);
            System.out.println("Code : " + code);
 
            OAuth2Operations oauthOperations = connectionFactory.getOAuthOperations();
            AccessGrant accessGrant = oauthOperations.exchangeForAccess(code, redirectUri, null);
            String accessToken = accessGrant.getAccessToken();
            System.out.println("AccessToken: " + accessToken);
            Long expireTime = accessGrant.getExpireTime();
        
            
            if (expireTime != null && expireTime < System.currentTimeMillis()) {
                accessToken = accessGrant.getRefreshToken();
                System.out.println("accessToken is expired. refresh token = {}" + accessToken);
            };
            
        
            Connection<Facebook> connection = connectionFactory.createConnection(accessGrant);
            Facebook facebook = connection == null ? new FacebookTemplate(accessToken) : connection.getApi();
            UserOperations userOperations = facebook.userOperations();
            
            try
            
 //			https://developers.facebook.com/docs/facebook-login/permissions/v2.2?locale=ko_KR
            
            {            
          String [] fields = { "email"};
//        	User userProfile = facebook.fetchObject("me", User.class, fields);
//        	System.out.println("유저이메일 : " + userProfile.getEmail());
//        	System.out.println("유저이름 : " + userProfile.getName());
//       	System.out.println("유저성별 : " + userProfile.getgender());
//        	System.out.println("유저좋아요 : " + userProfile.getlikes());
//         	System.out.println("유저 id : " + userProfile.getId());
//                System.out.println("유저 name : " + userProfile.getName());
                
            } catch (MissingAuthorizationException e) {
                e.printStackTrace();
            }
 
        
        } catch (Exception e) {
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
