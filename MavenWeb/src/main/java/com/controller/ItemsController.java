package com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.po.Items;
import com.service.ItemsService;
import com.service.ItemsServiceImpl;

@Controller
//@RequestMapping(value="/day3")//),method={RequestMethod.GET,RequestMethod.POST}) //窄化请求映射
//@RequestMapping(method={RequestMethod.GET,RequestMethod.POST})//支持什么请求
public class ItemsController {
	
	@Autowired
	private ItemsService itemsService;
	
	
	
	@RequestMapping("/itemsList")//.action可写可不写，/也是可写可不写
	public ModelAndView itemslist() throws Exception{
		List<Items> itemsList=itemsService.list();

		
		//创建modelAndView准备填充数据、设置视图
	    ModelAndView modelAndView = new ModelAndView();
				
				//填充数据
	    modelAndView.addObject("itemsList", itemsList);
				//视图
		modelAndView.setViewName("itemsList");
				
		return modelAndView;
		
	}
	/*HttpServletRequest request,HttpServletResponse response,HttpSession session,Model model*/
	//默认支持的参数  可加可不加
	@RequestMapping("/editItem")
	public String itemEdit(HttpServletRequest request,HttpServletResponse response,HttpSession session,Model model) throws Exception{
		String idr=request.getParameter("id");
		
		Items item= itemsService.selectItem(Integer.parseInt(idr));
		model.addAttribute("item", item);
		//request.setAttribute("item", item);

		//springmvc认为字符串是页面的名称
		return "editItem";	
	}
/*	@RequestMapping("/updateitem")
	public String updateitem(Items items )throws Exception{
		
		
		items.setCreatetime(new Date());
     	itemsService.updateItem(items);
		
		
		return "success";
	}*/
/*	@RequestMapping("/updateitem")
	public void updateitem(Items items ,HttpServletRequest request,HttpServletResponse response)throws Exception{
		
		
		items.setCreatetime(new Date());
     	itemsService.updateItem(items);
     	request.getRequestDispatcher("/WEB-INF/jsp/success.jsp").forward(request, response);	
	}*/
	
	@RequestMapping("/updateitem")
	public String updateitem(Items items ,HttpServletRequest request,HttpServletResponse response)throws Exception{
		
		
		items.setCreatetime(new Date());
     	itemsService.updateItem(items);
     	//return "forward:itemsList.action";	
     	return "forward:/WEB-INF/jsp/success.jsp";
     	//return "redirect:itemsList.action";
     	//return "redirect:https://www.mi.com/";
     	//return "redirect:WEB-INF/jsp/success.jsp";
	}
	
/*	@RequestMapping("/updateitem")
	public String updateitem(int id,String name,Float price,String detail )throws Exception{
		
		Items items=new Items();
		items.setId(id);
		items.setName(name);
		items.setPrice(price);
		items.setDetail(detail);
		items.setCreatetime(new Date());
     	itemsService.updateItem(items);
		
		
		return "success";
	}*/
	@RequestMapping("delAll.action")
	public String delAll(Integer[] ids,Model model)throws Exception{
		
		List<Integer> idss=new ArrayList<Integer>();
		for(int i:ids){
			idss.add(i);
		}
	
		List<Items> itemsList=itemsService.selectItemByIds(idss);
		System.out.println(itemsList);
		model.addAttribute(itemsList);
		return "itemsDel";
		
	}
	@RequestMapping("redirect.action")
	public void redirect(HttpServletRequest request,HttpServletResponse response) throws IOException{
		response.sendRedirect("https://www.mi.com/");
		
	}

}
