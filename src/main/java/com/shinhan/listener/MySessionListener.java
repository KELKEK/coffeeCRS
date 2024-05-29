package com.shinhan.listener;


import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import lombok.Getter;
import lombok.Setter;

/**
 * Application Lifecycle Listener implementation class MySessionListener
 *
 */
@Getter
@WebListener
public class MySessionListener implements HttpSessionListener {
	public String user_id;
	public String user_pw;
	public static int total_user = 0;
    /**
     * Default constructor. 
     */
    public MySessionListener() {
        // TODO Auto-generated constructor stub
    	System.out.println("MySessionListener 생성");
    }
    public MySessionListener(String user_id, String user_pw) {
    	// TODO Auto-generated constructor stub
    	this.user_id = user_id;
    	this.user_pw = user_pw;
    	
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    	System.out.println("사용자 접속");
    	++total_user;
    	//사용자 추가 접속 시
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
    	System.out.println("사용자 접속 해제");
    	--total_user;
    	//사용자 추가 접속 해제 시
    }
	
}
