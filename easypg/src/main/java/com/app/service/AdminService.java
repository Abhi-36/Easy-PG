package com.app.service;

import com.app.dto.AdminAuthResp;
import com.app.dto.AdminDto;
import com.app.dto.AuthRequest;
import com.app.pojos.Admin;

public interface AdminService 
{
	public Admin addAdmin(AdminDto admin);
	public AdminAuthResp signinAdmin(AuthRequest req);
}
