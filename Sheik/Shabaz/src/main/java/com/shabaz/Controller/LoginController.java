package com.shabaz.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shabaz.Entity.Users;
import com.shabaz.Service.SessionService;
import com.shabaz.Service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class LoginController {

	
	@Autowired
	private UserService userService;
	
	@Autowired
    private SessionService sessionService;
	
	@GetMapping("/login")
	public String loginPage() {		
		return "Login";
	}
	
	@PostMapping("/login")
    public String login(@RequestParam String userName, String password, Model model, HttpSession httpSession) {
        Users user = userService.findByUser(userName);

        if (user != null && user.getUserName().equals(userName) && user.getPassword().equals(password)) {
            if (sessionService.isUserLoggedIn(user.getUserId())) {
                model.addAttribute("error", "You are already logged in on another browser.");
                return "Login"; 
            }

            sessionService.storeSession(user.getUserId(), httpSession.getId());
            httpSession.setAttribute("userName", userName);

            return "Dashboard";
        } else {
            model.addAttribute("error", "Invalid username or password.");
            return "Login";
        }
    }
	
	@PostMapping("/logout")
	public String logout(HttpSession session) {
		String sessionId = session.getId();
		sessionService.removeSession(sessionId);
		session.invalidate();
		return "Login";
	}
}
