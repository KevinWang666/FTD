package com.zuikc.action;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/*
 * 无参数传递的页面跳转
 * */
import com.opensymphony.xwork2.ActionSupport;

@Controller("jumpAction")
@Scope("prototype")
public class JumpAction extends ActionSupport {

	private static final long serialVersionUID = -1909784491085953961L;
	
	private String dest;

	public String getDest() {
		return dest;
	}

	public void setDest(String dest) {
		this.dest = dest;
	}
	
}
