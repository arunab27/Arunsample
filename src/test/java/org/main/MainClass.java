package org.main;

import java.io.IOException;

import org.base.BaseClass;
import org.pojo.Pojo;

public class MainClass extends BaseClass {
	@SuppressWarnings("unused")
	public MainClass() throws IOException {
		launchbrowser();
		launchurl("http://adactinhotelapp.com/");
		maxwindow();
		towait();
		Pojo p = new Pojo();
		
		filltextbox(p.getTxuser(), readexcel(0, 0));
		filltextbox(p.getPass(), readexcel(1, 0));
		clk(p.getLogin());
		
		Select(p.getLoct(), readexcel(0, 1));
		Select(p.getHot(), readexcel(1, 1));
		Select(p.getRomtype(), readexcel(3, 1));
		Select(p.getRomno(), readexcel(3, 1));
		Select(p.getAdult(), readexcel(4, 1));
		Select(p.getChild(), readexcel(5, 1));
		
		 clk(p.getSubmit());
	     clk(p.getRadio());
	     clk(p.getRadio());
	     clk(p.getCont());
	     
	     filltextbox(p.getFrstname(), readexcel(0, 2));
	     filltextbox(p.getLstname(), readexcel(1, 2));
	     filltextbox(p.getAddress(), readexcel(2, 2));
	     filltextbox(p.getCcnum(),readexcel(3, 2));
	     
	     Select(p.getCctype(), readexcel(4, 2));
	     Select(p.getExpmonth(), readexcel(5, 2));
	     Select(p.getExpyear(), readexcel(6, 2));
	     
	     filltextbox(p.getCvv(), readexcel(7, 2));
	     clk(p.getBooknow());
	     
	     String t=gettext(p.getOrderno());
	     System.out.println();
	     
		
	}

}
